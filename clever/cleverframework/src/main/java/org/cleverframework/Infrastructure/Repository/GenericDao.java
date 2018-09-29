package org.cleverframework.infrastructure.repository;

import org.cleverframework.domain.AggregateRoot;

/**
 * Created by cass02 on 2017/4/18.
 */
public interface GenericDao<Model extends AggregateRoot, K> {

    Model get(K id);
}
