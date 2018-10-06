package org.cleverframework.commandhanding;

import org.cleverframework.commands.Command;
import org.cleverframework.commands.CommandContext;
import org.cleverframework.commands.CommandContextImpl;
import org.cleverframework.commands.CommandProcessorContext;
import org.cleverframework.domain.AggregateRoot;
import org.cleverframework.events.Event;
import org.cleverframework.events.EventPublisher;
import org.cleverframework.infrastructure.eventstores.EventStore;
import org.cleverframework.infrastructure.eventstores.EventStreamFactory;
import org.cleverframework.infrastructure.eventstores.EventStreamRecord;
import org.cleverframework.infrastructure.repository.AggregateRepository;
import org.cleverframework.infrastructure.snapshots.SnapshotFactory;
import org.cleverframework.infrastructure.snapshots.SnapshotStorage;
import org.cleverframework.messages.MessageResultSendChannelProxy;

import java.util.List;
import java.util.Map;

/**
 * 命令处理实现
 *
 * @author xiqin.liu
 */
public class CommandProcessorImpl implements CommandProcessor {

    private EventStore eventStore;

    private SnapshotStorage snapshotStorage;

    private EventPublisher eventPublisher;

    private AggregateRepository aggregateRepository;

    private MessageResultSendChannelProxy messageResultSendChannelProxy;

    public CommandProcessorImpl(
            EventPublisher eventPublisher,
            SnapshotStorage snapshotStorage,
            EventStore eventStore,
            AggregateRepository aggregateRepository,
            MessageResultSendChannelProxy messageResultSendChannelProxy) {

        this.eventPublisher = eventPublisher;
        this.snapshotStorage = snapshotStorage;
        this.eventStore = eventStore;
        this.aggregateRepository = aggregateRepository;
        this.messageResultSendChannelProxy = messageResultSendChannelProxy;
    }

    private AggregateRoot getChangedAggregateRoot(Map<String, AggregateRoot> aggregateRoots) {

        return aggregateRoots.values().iterator().next();
    }


    public <T extends Command> void process(CommandHandler<T> commandHandler, T command) {

    }

    @Override
    public <T extends Command> void execute(CommandProcessorContext context) {

        CommandContext commandContext = new CommandContextImpl(aggregateRepository);

        //命令处理
        context.getCommandHandler().handle(commandContext, context.getCommand());

        Map<String, AggregateRoot> aggregateRoots = commandContext.getAggregateRoots();

        if (aggregateRoots.size() == 0) {
            throw new RuntimeException("The changed aggregateRoots  size can not be zero.");
        }

        if (aggregateRoots.size() > 1) {
            throw new RuntimeException("The changed aggregateRoots just only one.");
        }

        //一个命令处理仅仅只能修改一个聚合根
        AggregateRoot changedAggregateRoot = getChangedAggregateRoot(aggregateRoots);

        changedAggregateRoot.increaseVersion();

        List<Event> unCommitEvents = changedAggregateRoot.getUnCommitEvents();

        EventStreamRecord eventStreamRecord = EventStreamFactory.create(changedAggregateRoot, context.getCommand().getCommandId());

        //追加事件流
        eventStore.appendEventsToStream(eventStreamRecord);

        //快照存储
        if (changedAggregateRoot.getVersion() % 3 == 0) {

            snapshotStorage.save(SnapshotFactory.create(changedAggregateRoot));
        }

        //发送事件(普通事件与领域事件)
        eventPublisher.publish(unCommitEvents);

        changedAggregateRoot.clear();

        messageResultSendChannelProxy.send(null, context.getRemoteEndPoint());
    }
}
