package org.apache.airavata.sga.api.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.apache.airavata.sga.api.resource.ExperimentResource;

/**
 * Created by goshenoy on 4/21/17.
 */
public class SGAWinkApplication extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(ExperimentResource.class);
		return classes;
	}
}
