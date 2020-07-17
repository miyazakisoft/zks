package com.github.zks;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/webapi")
public class MyApplication extends ResourceConfig {

	public MyApplication() {
		packages("com.github.zks");
		register(MultiPartFeature.class);
	}
}