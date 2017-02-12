package com.example.ramiboukadida.ttma.entities;

import java.io.Serializable;


/**
 * Entity implementation class for Entity: Conge
 *
 */

public class Conge implements Serializable {

	
	private int ID;
	private String CIN;
	private String DateDeb;
	private String DateFin;
	private String Verif;
	private static final long serialVersionUID = 1L;

	public Conge() {
		super();
	}   

	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}   
	public String getCIN() {
		return this.CIN;
	}

	public void setCIN(String CIN) {
		this.CIN = CIN;
	}   
	public String getDateDeb() {
		return this.DateDeb;
	}

	public void setDateDeb(String DateDeb) {
		this.DateDeb = DateDeb;
	}   
	public String getDateFin() {
		return this.DateFin;
	}

	public void setDateFin(String DateFin) {
		this.DateFin = DateFin;
	}   
	public String getVerif() {
		return this.Verif;
	}

	public void setVerif(String Verif) {
		this.Verif = Verif;
	}
	public Conge(int iD, String cIN, String dateDeb, String dateFin,
			String verif) {
		super();
		ID = iD;
		CIN = cIN;
		DateDeb = dateDeb;
		DateFin = dateFin;
		Verif = verif;
	}
	
   
}
