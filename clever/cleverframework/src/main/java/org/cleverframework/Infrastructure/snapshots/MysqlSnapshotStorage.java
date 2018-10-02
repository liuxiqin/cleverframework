package org.cleverframework.infrastructure.snapshots;

/**
 * MYSQL 快照存储实现]
 *
 * @author xiqin.liu
 */
public class MysqlSnapshotStorage implements SnapshotStorage {

    @Override
    public Snapshot getLastSnapshot(String aggregateRootId) {

        return null;
    }

    @Override
    public void save(Snapshot snapshot) {

    }
}
