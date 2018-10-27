package csu.java.tinyioc.beans;

/**
 * @author csu yan juefei
 */

public class BeanDefinition {
	private Object bean = null;
	
	private Class<?> beanClass = null;
	
	private String beanClassName = "";
	
	private PropertyValues propertyValues = new PropertyValues();
	
	public BeanDefinition() {}
	public BeanDefinition(Object obj) {
		this.bean = obj;
	}
	
	public Object getBean() {
		return this.bean;
	}

	public void setBean(Object obj) {
		this.bean = obj;
	}

	public Class getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class beanClass) {
		this.beanClass = beanClass;
	}

	public String getBeanClassName() {
		return beanClassName;
	}

	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
		
		try {
			this.beanClass = Class.forName(beanClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public PropertyValues getPropertyValues() {
		return propertyValues;
	}
	public void setPropertyValues(PropertyValues propertyValues) {
		this.propertyValues = propertyValues;
	}
	
	
}
