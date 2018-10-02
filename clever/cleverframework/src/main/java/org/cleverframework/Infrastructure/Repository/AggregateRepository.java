package org.cleverframework.infrastructure.repository;

import org.cleverframework.domain.AggregateRoot;

/**
 * 聚合资源库接口抽象
 *
 * @author xiqin.liu
 */
public interface AggregateRepository {

    /**
     * 获取聚合根
     *
     * @param aggregateRootId
     * @return
     */
    <T extends AggregateRoot> T get(String aggregateRootId);

    /**
     * 保存资源库
     *
     * @param aggregateRoot
     * @param <T>
     */
    <T extends AggregateRoot> void save(T aggregateRoot);
}
