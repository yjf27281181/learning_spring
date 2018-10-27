package csu.java.tinyioc.beans;

import java.util.HashMap;
import java.util.Map;

import csu.java.tinyioc.beans.io.ResourceLoader;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
	private Map<String,BeanDefinition> registry;
	private ResourceLoader resourceLoader ;
	public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
		this.registry = new HashMap();
	}
	public Map<String, BeanDefinition> getRegistry() {
		return registry;
	}
	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}
	
}
