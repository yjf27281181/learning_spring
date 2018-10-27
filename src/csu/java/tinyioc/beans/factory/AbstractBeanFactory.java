package csu.java.tinyioc.beans.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import csu.java.tinyioc.beans.BeanDefinition;

public abstract class AbstractBeanFactory implements BeanFactory{
	private Map<String, BeanDefinition> map = new ConcurrentHashMap();
	
	private final List<String> list = new ArrayList<String>();
	
	@Override
    public Object getBean(String name) throws Exception{
		BeanDefinition beanDefinition = map.get(name);
		if(beanDefinition == null) 
			throw new IllegalArgumentException("No bean named " + name + " is defined");
		
		Object bean = beanDefinition.getBean();
		if(bean == null) {
			bean = doCreateBean(beanDefinition);
		}
		return bean;
	}

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        map.put(name, beanDefinition);
        list.add(name);
	}
	
	public void preInstantiateSingletons() throws Exception {
		for(String name : list)
			getBean(name);
	}
	
	protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
