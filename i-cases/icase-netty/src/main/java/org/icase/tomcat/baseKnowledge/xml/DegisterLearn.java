package org.icase.tomcat.baseKnowledge.xml;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

import org.icase.tomcat.baseKnowledge.xml.bean.ChartRegistry;

public class DegisterLearn {
		public static void main(String[] args) throws MalformedURLException, Exception {
			new ChartRegistry().deregister(new File("D:\\Users\\sunkk\\Desktop\\test.xml"));
			for(URL url: new URLClassLoader(new URL[]{new File("H:\\Zip-server\\apache-tomcat-7.0.59\\lib\\catalina.jar").toURI().toURL()}).getURLs()){
				System.out.println(url.getProtocol());
				Manifest mf = new JarInputStream(new FileInputStream(url.getFile())).getManifest();
				System.out.println(mf);
			}
		}
}
