package csu.java.tinyioc.test.io;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import csu.java.tinyioc.io.Resource;
import csu.java.tinyioc.io.ResourceLoader;
import org.junit.Assert;

public class ResourceLoaderTest {
	@Test
	public void test() throws Exception {
		ResourceLoader resourceLoader = new ResourceLoader();
		Resource resource = resourceLoader.getResource("tinyioc.xml");
		InputStream inputStream = resource.getInputStream();
		
		Assert.assertNotNull(inputStream);
	}
}
