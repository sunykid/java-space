package org.icase.tomcat.baseKnowledge;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;

public class FileLearn {
	public static final String CATALINA_HOME="catalina.home";
	public static final String CATALINA_BASE="catalina.base";
	public static final String USER_DIR="user.dir";
	public static void main(String[] args) throws IOException, URISyntaxException, ClassNotFoundException {
		
		System.out.println(System.getProperty(USER_DIR));
		System.out.println(System.getProperty(CATALINA_HOME));
		System.out.println(System.getProperty(CATALINA_BASE));
		System.out.println(System.getProperty("catalina.config"));
		System.out.println(System.getProperty("java.io.tmpdir"));
		
		
		File file = new File("test.xml");
		
 		System.out.println(file.getCanonicalPath());
 		System.out.println(file.getAbsolutePath());
 		File file2 = new File(file,"..");
 		System.out.println(file2.getCanonicalPath());
 		System.out.println(file2.getAbsolutePath());
 		@SuppressWarnings("unused")
 		URL url = new File("H:\\Zip-server\\apache-tomcat-6.0.43\\lib\\catalina.jar").toURI().toURL();
 		URLClassLoader urlclassloader = new URLClassLoader(new URL[]{url});
 		Class<?> clazz = urlclassloader.loadClass("org.apache.catalina.startup.Catalina");
 		System.out.println(clazz.getClassLoader());
 		System.out.println(URLClassLoader.class.getClassLoader());
 		
	}
}
