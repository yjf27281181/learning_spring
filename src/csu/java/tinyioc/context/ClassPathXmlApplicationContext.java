package csu.java.tinyioc.context;

import java.util.Map;

import csu.java.tinyioc.beans.BeanDefinition;
import csu.java.tinyioc.beans.factory.AbstractBeanFactory;
import csu.java.tinyioc.beans.factory.AutowireCapableBeanFactory;
import csu.java.tinyioc.beans.io.ResourceLoader;
import csu.java.tinyioc.beans.xml.XmlBeanDefinitionReader;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext{

	String configLocation;
	
	public ClassPathXmlApplicationContext(String configLocation) throws Exception{
		this(configLocation, new AutowireCapableBeanFactory());
	}
	
	public ClassPathXmlApplicationContext(String configLocation,AbstractBeanFactory beanFactory) throws Exception{
		super(beanFactory);
		this.configLocation = configLocation;
		refresh();
	}

	@Override
	public void refresh() throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
		for(Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
		}
	}

	
}
