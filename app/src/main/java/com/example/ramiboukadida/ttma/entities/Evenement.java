package com.example.ramiboukadida.ttma.entities;





import java.io.Serializable;
import java.lang.String;
import java.util.Date;


/**
 * Entity implementation class for Entity: Evenement
 *
 */

public class Evenement implements Serializable {

	   
	
	private int ID_event;
	private String name_event;
	private String place_event;
	private Date date_event;
	private String program;
	private Integer nbr_participants;
	
	private Integer nbr_de_places;
	
	public Integer getNbr_de_places() {
		return nbr_de_places;
	}
	public void setNbr_de_places(Integer nbr_de_places) {
		this.nbr_de_places = nbr_de_places;
	}
	private float price;
    private byte[] image;
	private static final long serialVersionUID = 1L;

	public Evenement() {
		super();
	}   

	public int getID_event() {
		return this.ID_event;
	}

	public void setID_event(int ID_event) {
		this.ID_event = ID_event;
	}   
	
	public String getName_event() {
		return this.name_event;
	}

	public void setName_event(String name_event) {
		this.name_event = name_event;
	}   
	public String getPlace_event() {
		return this.place_event;
	}

	public void setPlace_event(String place_event) {
		this.place_event = place_event;
	}   
	public Date getDate_event() {
		return this.date_event;
	}

	public void setDate_event(Date date_event) {
		this.date_event = date_event;
	}   
 
	public String getProgram() {
		return this.program;
	}

	public void setProgram(String program) {
		this.program = program;
	}   
	public Integer getNbr_participants() {
		return this.nbr_participants;
	}

	public void setNbr_participants(Integer nbr_participants) {
		this.nbr_participants = nbr_participants;
	}   
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}   
	
	

	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Evenement(int iD_event, String name_event, String place_event,
			Date date_event, String program, Integer nbr_participants,
			Integer nbr_de_places, float price, byte[] image) {
		super();
		ID_event = iD_event;
		this.name_event = name_event;
		this.place_event = place_event;
		this.date_event = date_event;
		this.program = program;
		this.nbr_participants = nbr_participants;
		this.nbr_de_places = nbr_de_places;
		this.price = price;
		this.image = image;
	}

	
   
}
