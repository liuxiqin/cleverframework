package org.cleverframework.infrastructure.snapshots;

/**
 * 快照存储抽象类
 */
public interface SnapshotStorage {

    /**
     * 获取最后一次快照
     *
     * @param aggregateRootId
     * @return
     */
    Snapshot getLastSnapshot(String aggregateRootId);

    /*
     * 保存快照
     */
    void save(Snapshot snapshot);
}
