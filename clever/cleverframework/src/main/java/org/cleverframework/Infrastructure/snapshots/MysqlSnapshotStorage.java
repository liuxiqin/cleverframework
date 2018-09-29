package org.cleverframework.infrastructure.snapshots;

/**
 * MYSQL 快照存储实现
 */
public class MysqlSnapshotStorage implements SnapshotStorage {

    public Snapshot getLastSnapshot(String aggregateRootId) {

        return null;
    }

    @Override
    public void save(Snapshot snapshot) {

    }
}
