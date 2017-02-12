package com.example.ramiboukadida.ttma.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;
import java.util.List;



/**
 * Entity implementation class for Entity: Problem
 *
 */


public class Problem implements Serializable {

	
	private Integer id;
	private String title;
	private String description;
	private Date date;
	private Boolean resolved;
	private static final long serialVersionUID = 1L;
	private User user;
	private List<ProblemDiscussion> discussions;

	public Problem() {
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getResolved() {
		return resolved;
	}
	public void setResolved(Boolean resolved) {
		this.resolved = resolved;
	}

	public List<ProblemDiscussion> getDiscussions() {
		return discussions;
	}
	public void setDiscussions(List<ProblemDiscussion> discussions) {
		this.discussions = discussions;
	}
   
}
