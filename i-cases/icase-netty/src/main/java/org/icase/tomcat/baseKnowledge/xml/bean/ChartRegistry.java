package org.icase.tomcat.baseKnowledge.xml.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.digester.Digester;

public class ChartRegistry {
	private List<ChartConfig> registry = new ArrayList<>();

	
	public List<ChartConfig> getRegistry() {
		return registry;
	}


	public void setRegistry(List<ChartConfig> registry) {
		this.registry = registry;
	}

	public void deregister(File file) throws Exception{
		InputStream is = 
				new FileInputStream(file);
		Digester digester = new Digester();
		digester.push(this);
		digester.setValidating(false);
		
		digester.addObjectCreate("charts/chart","org.icase.tomcat.baseKnowledge.xml.bean.ChartConfig","classname");
		digester.addSetProperties("charts/chart");
		digester.addSetNext("charts/chart","register");
		digester.addBeanPropertySetter("charts/chart/legendVisible");
		digester.addBeanPropertySetter("charts/chart/toolTipsVisible");
		digester.addBeanPropertySetter("charts/chart/title");
		digester.addBeanPropertySetter("charts/chart/type");
		digester.addBeanPropertySetter("charts/chart/labelx");
		digester.addBeanPropertySetter("charts/chart/labely");
		digester.addBeanPropertySetter("charts/chart/width");
		digester.addBeanPropertySetter("charts/chart/height");
		digester.addBeanPropertySetter("charts/chart/hql");
		digester.addBeanPropertySetter("charts/chart/description");
		
		digester.parse(is);
		System.out.println(registry);
	}
	public void register(ChartConfig obj){ 
		registry.add(obj); 
		} 
}
