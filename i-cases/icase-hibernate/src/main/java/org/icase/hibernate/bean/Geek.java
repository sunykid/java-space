package org.icase.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

public class Geek extends Person {
	private String favouriteProgrammingLanguate;
	private Set<Project> projects = new HashSet<>();
	
	public String getFavouriteProgrammingLanguate() {
		return favouriteProgrammingLanguate;
	}

	public void setFavouriteProgrammingLanguate(String favouriteProgrammingLanguate) {
		this.favouriteProgrammingLanguate = favouriteProgrammingLanguate;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

}
