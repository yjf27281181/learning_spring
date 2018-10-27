package csu.java.tinyioc.test;

import java.util.Map;

import org.junit.Test;

import csu.java.tinyioc.factory.BeanFactory;
import csu.java.tinyioc.io.ResourceLoader;
import csu.java.tinyioc.xml.XmlBeanDefinitionReader;
import csu.java.tinyioc.beans.BeanDefinition;
import csu.java.tinyioc.factory.AbstractBeanFactory;
import csu.java.tinyioc.factory.AutowireCapableBeanFactory;

public class BeanFactoryTest {
	//@Test
	public void test() throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = 
				new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		for(Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
		}
		
		HelloWorldService helloWorldServer = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldServer.helloWorld();
	}
	
	@Test
	public void testPreInstantiate() throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = 
				new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
		for(Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
		}
		beanFactory.preInstantiateSingletons();
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
		
	}
}
