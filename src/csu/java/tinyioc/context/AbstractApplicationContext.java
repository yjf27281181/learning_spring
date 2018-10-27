package csu.java.tinyioc.context;

import csu.java.tinyioc.beans.BeanDefinition;
import csu.java.tinyioc.beans.factory.AbstractBeanFactory;

public abstract class AbstractApplicationContext implements ApplicationContext{
	
	protected AbstractBeanFactory beanFactory;
	
	public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
		super();
		this.beanFactory = beanFactory;
	}

	public void refresh() throws Exception{
    }

	@Override
	public Object getBean(String name) throws Exception {
		return beanFactory.getBean(name);
	}

}
