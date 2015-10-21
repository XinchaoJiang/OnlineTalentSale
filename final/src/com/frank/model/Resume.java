package com.frank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Resume entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "resume", catalog = "shop")
public class Resume implements java.io.Serializable {

	// Fields

	private Integer id;
	private String content;
	private String userName;
	private String time;

	// Constructors

	/** default constructor */
	public Resume() {
	}

	/** full constructor */
	public Resume(String content, String userName, String time) {
		this.content = content;
		this.userName = userName;
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

	@Column(name = "Content", length = 9999)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "userName")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "time")
	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}