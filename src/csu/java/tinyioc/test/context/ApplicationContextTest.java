package csu.java.tinyioc.test.context;

import org.junit.Test;

import csu.java.tinyioc.context.ApplicationContext;
import csu.java.tinyioc.context.ClassPathXmlApplicationContext;
import csu.java.tinyioc.test.HelloWorldService;

public class ApplicationContextTest {
	@Test
    public void test() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("tinyioc.xml");
		HelloWorldService helloWorldService = (HelloWorldService) context.getBean("helloWorldService");
        helloWorldService.helloWorld();
	}
}
