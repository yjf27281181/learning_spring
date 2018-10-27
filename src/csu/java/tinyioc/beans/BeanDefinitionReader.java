package csu.java.tinyioc.beans;

public interface BeanDefinitionReader {
	void loadBeanDefinitions(String location) throws Exception;
}
