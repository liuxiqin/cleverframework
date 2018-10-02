package org.cleverframework.infrastructure.dependency;

public interface BeanFactory {

    /**
     * 根据bean的名字，获取在IOC容器中得到bean实例
     */
    Object getBean(String name);

    /**
     * 根据bean的名字和Class类型来得到bean实例，增加了类型安全验证机制。
     */
    Object getBean(String name, Class requiredType);

    /**
     * 提供对bean的检索，看看是否在IOC容器有这个名字的bean
     */
    boolean containsBean(String name);

    /**
     * 根据bean名字得到bean实例，并同时判断这个bean是不是单例
     */
    boolean isSingleton(String name);

    /**
     * 得到bean实例的Class类型
     */
    Class getType(String name);

    /**
     * 得到bean的别名，如果根据别名检索，那么其原名也会被检索出来
     */
    String[] getAliases(String name);
}
