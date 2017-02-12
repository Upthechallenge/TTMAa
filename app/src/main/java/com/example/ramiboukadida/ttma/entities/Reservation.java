package com.example.ramiboukadida.ttma.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.sql.Date;



/**
 * Entity implementation class for Entity: Reservation
 *
 */


public class Reservation implements Serializable {

	   
	
	private Integer id;
	private Date dateReserv;
	private static final long serialVersionUID = 1L;
	private User user;
	private Hotel hotel;
	
	private Boolean approvation;

	public Reservation() {
		super();
	}   


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Date getDateReserv() {
		return this.dateReserv;
	}

	public void setDateReserv(Date dateReserv) {
		this.dateReserv = dateReserv;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Boolean getApprovation() {
		return approvation;
	}
	public void setApprovation(Boolean approvation) {
		this.approvation = approvation;
	}
   
}
