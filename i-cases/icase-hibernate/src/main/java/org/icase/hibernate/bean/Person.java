package org.icase.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

//@javax.persistence.Entity(name="t1")
public class Person {
	private String name;
//	private int id;
	private String id;
	
	private IdCard idCard;
	
	private Set<Phone> phones = new HashSet();
	
	public String getId() {
		return id;
	}
	public Set<Phone> getPhones() {
		return phones;
	}
	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public IdCard getIdCard() {
		return idCard;
	}
	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}
	
}
