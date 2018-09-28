package org.cleverframework.Infrastructure.Repository;

import org.cleverframework.domain.AggregateRoot;

/**
 * Created by cass02 on 2017/4/18.
 */
public class GenericDaoImpl<Model extends AggregateRoot,K> implements  GenericDao<Model,K> {

    public Model get(K id) {
        return null;
    }
}
