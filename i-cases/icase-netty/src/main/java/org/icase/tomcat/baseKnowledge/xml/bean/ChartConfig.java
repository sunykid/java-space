package org.icase.tomcat.baseKnowledge.xml.bean;

public class ChartConfig {
	private String id;
	private boolean legendVisible;
	private boolean toolTipsVisible;
	private String type;
	private String labelx;
	private String labely;
	private double width;
	private double height;
	private String hql;
	private String description;
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLabely() {
		return labely;
	}
	public void setLabely(String labely) {
		this.labely = labely;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isLegendVisible() {
		return legendVisible;
	}
	public void setLegendVisible(boolean legendVisible) {
		this.legendVisible = legendVisible;
	}
	public boolean isToolTipsVisible() {
		return toolTipsVisible;
	}
	public void setToolTipsVisible(boolean toolTipsVisible) {
		this.toolTipsVisible = toolTipsVisible;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLabelx() {
		return labelx;
	}
	public void setLabelx(String labelx) {
		this.labelx = labelx;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getHql() {
		return hql;
	}
	public void setHql(String hql) {
		this.hql = hql;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+"\n"+
			   this.labelx+"\n"+
			   this.labely+"\n"+
			   this.width+"\n"+
			   this.height+"\n"+
			   this.description+"\n"+
			   this.hql+"\n";
	}
	
}
