package org.cleverframework.infrastructure.repository;

import org.cleverframework.domain.AggregateRoot;

import java.io.Serializable;

/**
 * DAO抽象
 *
 * @author xiqin.liu
 */
public interface GenericDao {

    <T extends AggregateRoot, Id extends Serializable> T get(Id id);

    <T extends AggregateRoot> void save(T entity);
}
