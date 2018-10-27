package csu.java.tinyioc.beans.factory;

import csu.java.tinyioc.beans.BeanDefinition;

/**
 * @author csu yan juefei
 */

public interface BeanFactory {
	
	Object getBean(String name) throws Exception ;
}
