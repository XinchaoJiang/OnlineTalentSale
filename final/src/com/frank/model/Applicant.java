package com.frank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Applicant entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "applicant", catalog = "shop")
public class Applicant implements java.io.Serializable {

	// Fields

	private Integer id;
	private String projectName;
	private String userName;
	private String publisher;
	private String time;

	// Constructors

	/** default constructor */
	public Applicant() {
	}

	/** full constructor */
	public Applicant(String projectName, String userName, String publisher,
			String time) {
		this.projectName = projectName;
		this.userName = userName;
		this.publisher = publisher;
		this.time = time;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "projectName")
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "userName")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "publisher")
	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Column(name = "time")
	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}