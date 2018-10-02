package org.cleverframework.infrastructure.dependency;

/**
 * bean 工厂实现类
 *
 * @author xiqin.liu
 */
public class BeanFactoryImpl implements BeanFactory {

    @Override
    public Object getBean(String name) {
        return null;
    }

    @Override
    public Object getBean(String name, Class requiredType) {
        return null;
    }

    @Override
    public boolean containsBean(String name) {
        return false;
    }

    @Override
    public boolean isSingleton(String name) {
        return false;
    }

    @Override
    public Class getType(String name) {
        return null;
    }

    @Override
    public String[] getAliases(String name) {
        return new String[0];
    }
}
