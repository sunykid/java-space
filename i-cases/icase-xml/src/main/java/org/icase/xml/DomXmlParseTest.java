package org.icase.xml;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
/**
 * 参考文件:
 * http://www.blogjava.net/DLevin/archive/2012/11/18/391545.html
 * 
 * @author sunkk
 *
 */
public class DomXmlParseTest {
	
	private static Logger logger = Logger.getLogger(DomXmlParseTest.class.getName()); 
	
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
				//通过publicId ，systemId查找实体
				return null;
				//return new InputSource();
			}
		});
		
		documentBuilder.setErrorHandler(new ErrorHandler() {
			
			public void warning(SAXParseException exception) throws SAXException {
				// TODO Auto-generated method stub
				logger.warning(exception.getMessage());
				
			}
			
			public void fatalError(SAXParseException exception) throws SAXException {
				// TODO Auto-generated method stub
				logger.warning(exception.getMessage());
			}
			
			public void error(SAXParseException exception) throws SAXException {
				// TODO Auto-generated method stub
				logger.warning(exception.getMessage());
			}
		});
		
		Document document = documentBuilder.parse(file);
		Element root = document.getDocumentElement();
		printNode(root);
	}

	private static void printNode(Element e) {
		// TODO Auto-generated method stub
	    if (e.hasChildNodes()) {  
            NodeList subList = e.getChildNodes();  
            for (int i = 0; i < subList.getLength(); i++) {  
                Node n = subList.item(i);  
                if (n instanceof Element) {  
                    printNode((Element) n);  
                }  
            }  
        } else {  
            StringBuffer sb = new StringBuffer();  
            sb.append("<").append(e.getNodeName());  
            if (e.hasAttributes()) {  
                NamedNodeMap attr = e.getAttributes();  
                for (int i = 0; i < attr.getLength(); i++) {  
                    sb.append(" ").append(attr.item(i).getNodeName()).append("=\"").append(attr.item(i).getNodeValue()).append("\"");  
                }  
            }  
            sb.append(">");  
  
            String content = e.getNodeValue();  
            if (content!=null) {  
                sb.append(content);  
            }  
            sb.append("</" + e.getNodeName() + ">");  
            System.out.println(sb);  
  
        }  
	}
}
