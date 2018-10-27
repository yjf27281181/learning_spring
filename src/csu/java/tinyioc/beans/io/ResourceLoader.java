package csu.java.tinyioc.beans.io;

import java.net.URL;

public class ResourceLoader {
	public Resource getResource(String location) {
		URL resource = this.getClass().getClassLoader().getResource(location);
		System.out.println(this.getClass());
		System.out.println(this.getClass().getClassLoader());
		System.out.println(this.getClass().getClassLoader().getResource(""));
		return new UrlResource(resource);
	}
}
