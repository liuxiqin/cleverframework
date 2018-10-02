package org.cleverframework.infrastructure.snapshots;

import org.cleverframework.domain.AggregateRoot;
import org.cleverframework.infrastructure.serializes.BinarySerializer;
import org.cleverframework.infrastructure.serializes.BinarySerializerImpl;
import org.cleverframework.infrastructure.serializes.JsonSerializer;

import java.util.Date;
import java.util.UUID;

/**
 * 快照工厂方法
 *
 * @author xiqin.liu
 */
public class SnapshotFactory {

    private static JsonSerializer jsonSerializer;

    public static <T extends AggregateRoot> Snapshot create(T aggregateRoot) {

        Snapshot snapshot = new Snapshot();

        snapshot.setSnapshotId(UUID.randomUUID().toString());
        snapshot.setTimeStamp(new Date());
        snapshot.setVersion(aggregateRoot.getVersion());
        snapshot.setAggregateRootBytes(jsonSerializer.toBytes(aggregateRoot));
        snapshot.setAggregateRootId(aggregateRoot.getId());

        return snapshot;
    }
}
