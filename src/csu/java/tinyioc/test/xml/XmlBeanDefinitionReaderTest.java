package csu.java.tinyioc.test.xml;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import csu.java.tinyioc.beans.BeanDefinition;
import csu.java.tinyioc.io.ResourceLoader;
import csu.java.tinyioc.xml.XmlBeanDefinitionReader;

public class XmlBeanDefinitionReaderTest {
	@Test
	public void test() throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
		Assert.assertTrue(registry.size() > 0);
	}
	
}
