package org.cleverframework.initializes;

import org.cleverframework.infrastructure.eventsourcings.AggregateRootMemoryCache;
import org.cleverframework.infrastructure.eventsourcings.AggregateRootMemoryCacheImpl;
import org.cleverframework.infrastructure.eventstores.EventStore;
import org.cleverframework.infrastructure.eventstores.MysqlEventStoreImpl;
import org.cleverframework.infrastructure.repository.AggregateRepository;
import org.cleverframework.infrastructure.repository.EventSourcingAggregateRepository;
import org.cleverframework.infrastructure.repository.GenericDao;
import org.cleverframework.infrastructure.repository.GenericDaoImpl;
import org.cleverframework.infrastructure.serializes.BinarySerializer;
import org.cleverframework.infrastructure.serializes.BinarySerializerImpl;
import org.cleverframework.infrastructure.serializes.JacksonSerializerImpl;
import org.cleverframework.infrastructure.serializes.JsonSerializer;
import org.cleverframework.infrastructure.snapshots.MysqlSnapshotStorage;
import org.cleverframework.infrastructure.snapshots.SnapshotStorage;

/**
 * 框架启动入口和资源加载初始化入口
 *
 * @author xiqin.liu
 */
public class CleverApplication {


    /**
     * 框架启动入口（BEAN资源加载，消费者启动）
     */
    public static void run(String[] args) {

        CleverApplicationContext.getBeanContainer()
                .add(SnapshotStorage.class, new MysqlSnapshotStorage())
                .add(JsonSerializer.class, new JacksonSerializerImpl())
                .add(BinarySerializer.class, new BinarySerializerImpl())
                .add(GenericDao.class, new GenericDaoImpl())
                .add(EventStore.class, new MysqlEventStoreImpl())
                .add(AggregateRootMemoryCache.class, new AggregateRootMemoryCacheImpl())
                .add(AggregateRepository.class,
                        new EventSourcingAggregateRepository(
                                CleverApplicationContext.getBeanContainer().get(EventStore.class),
                                CleverApplicationContext.getBeanContainer().get(SnapshotStorage.class),
                                CleverApplicationContext.getBeanContainer().get(AggregateRootMemoryCache.class)))
        ;
    }

    /**
     * 释放框架已加载资源
     */
    public static void release() {

    }

    /**
     * 刷新框架加载资源
     */
    public static void refresh() {

    }

}