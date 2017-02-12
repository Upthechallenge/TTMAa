package com.example.ramiboukadida.ttma.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;



/**
 * Entity implementation class for Entity: ProblemDiscussion
 *
 */


public class ProblemDiscussion implements Serializable {

	   
	
	private Integer id;
	private String description;

	private String title;
	private Date date;
	private User user;
	private Problem problem;
	private String sender;
	private static final long serialVersionUID = 1L;

	public ProblemDiscussion() {
		super();
	}   
	

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	 
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
   
}
