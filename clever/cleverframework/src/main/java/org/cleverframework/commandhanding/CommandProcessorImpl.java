package org.cleverframework.commandhanding;

import org.cleverframework.Infrastructure.eventstores.*;
import org.cleverframework.Infrastructure.snapshots.MysqlSnapshotStorage;
import org.cleverframework.Infrastructure.snapshots.Snapshot;
import org.cleverframework.Infrastructure.snapshots.SnapshotFactory;
import org.cleverframework.Infrastructure.snapshots.SnapshotStorage;
import org.cleverframework.commands.Command;
import org.cleverframework.commands.CommandContext;
import org.cleverframework.commands.CommandContextImpl;
import org.cleverframework.domain.AggregateRoot;
import org.cleverframework.events.Event;
import org.cleverframework.events.EventPublisher;
import org.cleverframework.events.EventPublisherImpl;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-04-09 .
 */
public class CommandProcessorImpl  implements CommandProcessor{

    private EventStore eventStore = new MysqlEventStoreImpl();

    private SnapshotStorage snapshotStorage = new MysqlSnapshotStorage();

    private EventPublisher eventPublisher = new EventPublisherImpl();

    public <T extends Command> void process(CommandHandlerInvoker invoker, T command) throws Exception {

        CommandContext commandContext = new CommandContextImpl();

        invoker.handle(commandContext, command);

        Map<String, AggregateRoot> aggregateRoots = commandContext.getAggregateRoots();

        if (aggregateRoots.size() == 0)
            throw new Exception("the changed aggregateRoot  size can not be zero.");

        if (aggregateRoots.size() > 1)
            throw new Exception("the changed aggregateRoot just only one.");

        //one CommandHandle just  change only one AggregateRoot
        AggregateRoot changedAggregateRoot = getChangedAggregateRoot(aggregateRoots);

        List<Event> unCommitEvents = changedAggregateRoot.getUnCommitEvents();

        EventStreamRecord eventStreamRecord = EventStreamFactory.create(changedAggregateRoot, command.getId());

        eventStore.appendEventsToStream(eventStreamRecord);

        if (changedAggregateRoot.getVersion() % 3 == 0) {
            Snapshot snapshot = SnapshotFactory.create(changedAggregateRoot);
            snapshotStorage.create(snapshot);
        }

        eventPublisher.publish(unCommitEvents);

        changedAggregateRoot.clear();

    }

    private AggregateRoot getChangedAggregateRoot(Map<String, AggregateRoot> aggregateRoots) {
        return aggregateRoots.values().iterator().next();
    }


}
