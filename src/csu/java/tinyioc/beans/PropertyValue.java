package csu.java.tinyioc.beans;

public class PropertyValue {
	String name;
	Object value;
	public PropertyValue(String name, Object value) {
		super();
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public Object getValue() {
		return value;
	}
}
