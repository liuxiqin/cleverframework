package org.cleverframework.commandhanding;

import org.cleverframework.Infrastructure.Repository.Repository;
import org.cleverframework.Infrastructure.eventstores.EventStream;
import org.cleverframework.Infrastructure.eventstores.EventStreamFactory;
import org.cleverframework.commands.Command;
import org.cleverframework.commands.CommandContext;
import org.cleverframework.commands.CommandContextImpl;
import org.cleverframework.domain.AggregateRoot;
import org.cleverframework.events.Event;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-04-09 .
 */
public class CommandProcessor {

    @Resource
    private Repository repository;

    public <T extends Command> void process(CommandHandlerInvoker invoker, T command) throws Exception {

        CommandContext commandContext = new CommandContextImpl();

        invoker.handle(commandContext, command);

        Map<String, AggregateRoot> aggregateRoots = commandContext.getAggregateRoots();

        if (aggregateRoots.size() == 0)
            ;

        if (aggregateRoots.size() > 1)
            ;

        //one CommandHandle just  change only one AggregateRoot
        AggregateRoot changedAggregateRoot = getFirst(aggregateRoots);

        //get the changedUnCommitEvents

        List<Event> unCommitEvents = changedAggregateRoot.getUnCommitEvents();

        //change the event to EventStream to save eventstore

        EventStream eventStream = EventStreamFactory.create(changedAggregateRoot , command.getId());


        //create the AggregateRoot snapshot buy step 3

        //eventPublisher to publish event for sagas/processmanager or readmodel

        //clear the changed on the end

        changedAggregateRoot.clear();

    }

    private AggregateRoot getFirst(Map<String, AggregateRoot> aggregateRoots) {

        return aggregateRoots.values().iterator().next();
    }

}
