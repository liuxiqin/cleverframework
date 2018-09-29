package org.cleverframework.infrastructure.snapshots;

import org.cleverframework.domain.AggregateRoot;
import org.cleverframework.infrastructure.serializes.BinarySerializer;
import org.cleverframework.infrastructure.serializes.BinarySerializerImpl;

import java.util.Date;
import java.util.UUID;

/**
 * 快照工厂方法
 */
public class SnapshotFactory {

    private static BinarySerializer binarySerializer = new BinarySerializerImpl();

    public static <T extends AggregateRoot> Snapshot create(T aggregateRoot) {

        Snapshot snapshot = new Snapshot();

        snapshot.setSnapshotId(UUID.randomUUID().toString());
        snapshot.setTimeStamp(new Date());
        snapshot.setVersion(aggregateRoot.getVersion());
        snapshot.setAggregateRootBytes(binarySerializer.serialize(aggregateRoot));
        snapshot.setAggregateRootId(aggregateRoot.getId());

        return snapshot;
    }
}
