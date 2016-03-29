package org.icase.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

public class Project {
	private String id;
	private String title;
	private Set<Geek> geeks = new HashSet<>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Set<Geek> getGeeks() {
		return geeks;
	}
	public void setGeeks(Set<Geek> geeks) {
		this.geeks = geeks;
	}
	
}
