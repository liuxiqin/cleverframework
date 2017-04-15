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
public interface CommandProcessor {

    <T extends Command> void process(CommandHandler<T> commandHandler,  T command) throws Exception;
}