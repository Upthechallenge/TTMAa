package com.example.ramiboukadida.ttma.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;



/**
 * Entity implementation class for Entity: User
 *
 */


public class User implements Serializable {

	   
	
	private Integer id;
	private String name;
	private String email;
	private static final long serialVersionUID = 1L;
	private List<Problem> problems;
	private List<ProblemDiscussion> discussions;
	private List<Reservation> reservations;
	

	public User() {
		super();
	}   

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Problem> getProblems() {
		return problems;
	}
	public void setProblems(List<Problem> problems) {
		this.problems = problems;
	}

	public List<ProblemDiscussion> getDiscussions() {
		return discussions;
	}
	public void setDiscussions(List<ProblemDiscussion> discussions) {
		this.discussions = discussions;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
   
}
