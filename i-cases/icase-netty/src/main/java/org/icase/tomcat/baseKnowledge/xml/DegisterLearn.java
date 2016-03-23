package org.icase.tomcat.baseKnowledge.xml;

import java.io.File;
import java.net.MalformedURLException;

import org.icase.tomcat.baseKnowledge.xml.bean.ChartRegistry;

public class DegisterLearn {
		public static void main(String[] args) throws MalformedURLException, Exception {
			new ChartRegistry().deregister(new File("C:\\Users\\sunkunkuan\\Desktop\\test.xml"));
		}
}
