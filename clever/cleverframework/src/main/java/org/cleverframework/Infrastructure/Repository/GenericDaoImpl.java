package org.cleverframework.infrastructure.repository;

import org.cleverframework.domain.AggregateRoot;

import java.io.Serializable;

/**
 * dao 层的通用处理
 *
 * @author xiqin.liu
 */
public class GenericDaoImpl implements GenericDao {

    @Override
    public <T extends AggregateRoot, Id extends Serializable> T get(Id id) {

        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends AggregateRoot> void save(T entity) {

        throw new UnsupportedOperationException();
    }
}
