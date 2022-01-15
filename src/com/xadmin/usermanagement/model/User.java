package com.xadmin.usermanagement.model;

/**
 * User.java
 * This is a model class represents a User entity
 * @author Ramesh Fadatare
 *
 */
public class User {
	protected int id;
	protected String name;
	protected String sclass;
	protected String subject;
	protected String teacher;
	
	public User() {
	}
	
	public User(String name, String sclass, String subject, String teacher) {
		super();
		this.name = name;
		this.sclass = sclass;
		this.subject = subject;
		this.teacher = teacher;
	}
	
	public User(String name) {
		super();
		this.name = name;
		
	}
	public User(int id, String name, String sclass, String subject, String teacher) {
		super();
		this.id = id;
		this.name = name;
		this.sclass = sclass;
		this.subject = subject;
		this.teacher = teacher;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
}