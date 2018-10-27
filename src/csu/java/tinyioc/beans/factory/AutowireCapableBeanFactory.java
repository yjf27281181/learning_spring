package csu.java.tinyioc.beans.factory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import csu.java.tinyioc.beans.BeanDefinition;
import csu.java.tinyioc.beans.BeanReference;
import csu.java.tinyioc.beans.PropertyValue;

/**
 * @author yanjuefei
 */

public class AutowireCapableBeanFactory extends AbstractBeanFactory{

	@Override
	protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception{
		Object bean = createBeanInstance(beanDefinition);
		beanDefinition.setBean(bean);
		applyPropertyValues(bean, beanDefinition);
		return bean;
	}
	
	protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
		return beanDefinition.getBeanClass().getDeclaredConstructor().newInstance();
	}
	
	protected void applyPropertyValues(Object bean, BeanDefinition mbd ) throws Exception{
		for(PropertyValue pv : mbd.getPropertyValues().getPropertyValues()) {
			Field fd = bean.getClass().getDeclaredField(pv.getName());
			fd.setAccessible(true);
			Object value = pv.getValue();
			if(value instanceof BeanReference) {
				BeanReference beanReference = (BeanReference) value;
				value = getBean(beanReference.getName());
			}
			fd.set(bean, value);
		}
	}
}
