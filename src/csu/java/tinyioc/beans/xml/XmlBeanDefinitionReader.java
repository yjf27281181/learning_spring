package csu.java.tinyioc.beans.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import csu.java.tinyioc.beans.AbstractBeanDefinitionReader;
import csu.java.tinyioc.beans.BeanDefinition;
import csu.java.tinyioc.beans.BeanReference;
import csu.java.tinyioc.beans.PropertyValue;
import csu.java.tinyioc.beans.io.ResourceLoader;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{

	public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
		super(resourceLoader);
	}

	@Override
	public void loadBeanDefinitions(String location) throws Exception {
		InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
		doLoadBeanDefinition(inputStream); 
	}

	private void doLoadBeanDefinition(InputStream inputStream) throws Exception{
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(inputStream);
		
		registerBeanDefinition(doc);
		inputStream.close();
	}

	private void registerBeanDefinition(Document doc) {
		// TODO Auto-generated method stub
		Element root = doc.getDocumentElement();
		parseBeanDefinitions(root);
	}

	private void parseBeanDefinitions(Element root) {
		// TODO Auto-generated method stub
		NodeList nl = root.getChildNodes();
		for(int i=0;i<nl.getLength();i++) {
			if(nl.item(i) instanceof Element) {
				processBeanDefinition((Element)nl.item(i));
			}
		}
	}

	private void processBeanDefinition(Element ele) {
		String name = ele.getAttribute("name");
		String className = ele.getAttribute("class");
		BeanDefinition beanDefinition = new BeanDefinition();
		processProperty(ele, beanDefinition);
		beanDefinition.setBeanClassName(className);
		getRegistry().put(name, beanDefinition);
		
	}

	private void processProperty(Element ele, BeanDefinition beanDefinition) {
		NodeList nodeProperties = ele.getElementsByTagName("property");
		for(int i=0;i<nodeProperties.getLength();i++) {
			Node node = nodeProperties.item(i);
			if(node instanceof Element) {
				Element propertyEle = (Element) node;
				String name = propertyEle.getAttribute("name");
				String value = propertyEle.getAttribute("value");
				if(value != null && value.length()>0)
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
				else {
					String ref = propertyEle.getAttribute("ref");
					if (ref == null || ref.length() == 0) {
						throw new IllegalArgumentException("Configuration problem: <property> element for property '"
								+ name + "' must specify a ref or value");
					}
					BeanReference beanReference = new BeanReference(ref);
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
					
				}
					
			}
		}
		
		
	}
	
	
}
