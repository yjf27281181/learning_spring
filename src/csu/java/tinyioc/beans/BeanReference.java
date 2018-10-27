package csu.java.tinyioc.beans;

public class BeanReference {
	private Object bean;
	private String name;
	
	public BeanReference(String name) {
		super();
		this.name = name;
	}
	public Object getBean() {
		return bean;
	}
	public void setBean(Object bean) {
		this.bean = bean;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
