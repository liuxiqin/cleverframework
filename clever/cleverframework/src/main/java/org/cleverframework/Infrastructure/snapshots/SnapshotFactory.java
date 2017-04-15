package org.cleverframework.Infrastructure.snapshots;

import org.cleverframework.Infrastructure.serializes.BinarySerializer;
import org.cleverframework.Infrastructure.serializes.BinarySerializerImpl;
import org.cleverframework.domain.AggregateRoot;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by cass02 on 2017/4/15.
 */
public class SnapshotFactory {

    private static BinarySerializer binarySerializer = new BinarySerializerImpl();

    public static <T extends AggregateRoot> Snapshot create(T aggregateRoot) throws IOException {

        Snapshot snapshot = new Snapshot();

        snapshot.setSnapshotId(UUID.randomUUID().toString());
        snapshot.setTimeStamp(new Date());
        snapshot.setVersion(aggregateRoot.getVersion());
        snapshot.setAggregateRootBytes(binarySerializer.serialize(aggregateRoot));
        snapshot.setAggregateRootId(aggregateRoot.getId());

        return snapshot;
    }
}
