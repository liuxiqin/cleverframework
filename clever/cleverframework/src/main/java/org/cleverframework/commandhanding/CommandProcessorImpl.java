package org.cleverframework.commandhanding;

import org.cleverframework.infrastructure.eventstores.*;
import org.cleverframework.infrastructure.repository.AggregateRepository;
import org.cleverframework.infrastructure.snapshots.MysqlSnapshotStorage;
import org.cleverframework.infrastructure.snapshots.Snapshot;
import org.cleverframework.infrastructure.snapshots.SnapshotFactory;
import org.cleverframework.infrastructure.snapshots.SnapshotStorage;
import org.cleverframework.commands.Command;
import org.cleverframework.commands.CommandContext;
import org.cleverframework.commands.CommandContextImpl;
import org.cleverframework.commands.CommandProcessorContext;
import org.cleverframework.domain.AggregateRoot;
import org.cleverframework.events.Event;
import org.cleverframework.events.EventPublisher;
import org.cleverframework.events.EventPublisherImpl;

import java.util.List;
import java.util.Map;

/**
 * 命令处理
 *
 * @author xiqin.liu
 */
public class CommandProcessorImpl implements CommandProcessor {

    private EventStore eventStore;

    private SnapshotStorage snapshotStorage;

    private EventPublisher eventPublisher;

    private AggregateRepository aggregateRepository;

    public CommandProcessorImpl(
            EventPublisher eventPublisher,
            SnapshotStorage snapshotStorage,
            EventStore eventStore,
            AggregateRepository aggregateRepository) {

        this.eventPublisher = eventPublisher;
        this.snapshotStorage = snapshotStorage;
        this.eventStore = eventStore;
        this.aggregateRepository = aggregateRepository;
    }

    private AggregateRoot getChangedAggregateRoot(Map<String, AggregateRoot> aggregateRoots) {

        return aggregateRoots.values().iterator().next();
    }


    public <T extends Command> void process(CommandHandler<T> commandHandler, T command) {

    }

    @Override
    public <T extends Command> void process(CommandProcessorContext context) {

        CommandContext commandContext = new CommandContextImpl(aggregateRepository);

        context.getCommandHandler().handle(commandContext, context.getCommand());

        Map<String, AggregateRoot> aggregateRoots = commandContext.getAggregateRoots();

        if (aggregateRoots.size() == 0) {
            throw new RuntimeException("The changed aggregateRoots  size can not be zero.");
        }

        if (aggregateRoots.size() > 1) {
            throw new RuntimeException("The changed aggregateRoots just only one.");
        }

        //one CommandHandle just  change only one AggregateRoot
        //一个命令处理仅仅只能修改一个聚合根
        AggregateRoot changedAggregateRoot = getChangedAggregateRoot(aggregateRoots);

        List<Event> unCommitEvents = changedAggregateRoot.getUnCommitEvents();

        EventStreamRecord eventStreamRecord = EventStreamFactory.create(changedAggregateRoot, context.getCommand().getCommandId());

        eventStore.appendEventsToStream(eventStreamRecord);

        if (changedAggregateRoot.getVersion() % 3 == 0) {
            Snapshot snapshot = SnapshotFactory.create(changedAggregateRoot);
            snapshotStorage.save(snapshot);
        }

        eventPublisher.publish(unCommitEvents);

        changedAggregateRoot.clear();

    }
}
