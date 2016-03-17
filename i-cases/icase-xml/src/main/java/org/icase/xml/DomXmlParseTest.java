package org.icase.xml;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DomXmlParseTest {
	public static final String SCHEMA_LANGUAGE_ATTRIBUTE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";  
	public static final String XSD_SCHEMA_LANGUAGE = "http://www.w3.org/2001/XMLSchema"; 
	
	public static void main(String[] args) throws Exception {
		URL url = DomXmlParseTest.class.getResource("/spring-mybatis.xml");
		File file = new File(url.getFile());
		
		testDomBuilder(file);
	}

	private static void testDomBuilder(File file) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setValidating(true);
		//设置验证的方式为xsd
		factory.setAttribute(SCHEMA_LANGUAGE_ATTRIBUTE, XSD_SCHEMA_LANGUAGE);
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		
		documentBuilder.setEntityResolver(new EntityResolver() {
			
			public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
				
				return null;
			}
		});
	}
}
