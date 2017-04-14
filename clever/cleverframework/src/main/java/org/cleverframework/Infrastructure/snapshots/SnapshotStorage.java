package org.cleverframework.Infrastructure.snapshots;

/**
 * Created by Administrator on 2017-04-13 .
 */
public interface SnapshotStorage {

    Snapshot getLastSnapshot(String aggregateRootId);

    void create(Snapshot snapshot);
}
