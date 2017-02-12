package com.example.ramiboukadida.ttma.entities;

import java.io.Serializable;


/**
 * Entity implementation class for Entity: OnlineConsultations
 *
 */

public class OnlineConsultations implements Serializable {

	
	private int IDappointement;
	private String DoctorNAmeapp;
	private String PatientNAmeApp;
	private String DateApp;
	private static final long serialVersionUID = 1L;

	public OnlineConsultations() {
		super();
	}   

	public int getIDappointement() {
		return this.IDappointement;
	}

	public void setIDappointement(int IDappointement) {
		this.IDappointement = IDappointement;
	}   
	public String getDoctorNAmeapp() {
		return this.DoctorNAmeapp;
	}

	public void setDoctorNAmeapp(String DoctorNAmeapp) {
		this.DoctorNAmeapp = DoctorNAmeapp;
	}   
	public String getPatientNAmeApp() {
		return this.PatientNAmeApp;
	}

	public void setPatientNAmeApp(String PatientNAmeApp) {
		this.PatientNAmeApp = PatientNAmeApp;
	}   
	public String getDateApp() {
		return this.DateApp;
	}

	public void setDateApp(String DateApp) {
		this.DateApp = DateApp;
	}
	public OnlineConsultations(int iDappointement, String doctorNAmeapp,
							   String patientNAmeApp, String dateApp) {
		super();
		IDappointement = iDappointement;
		DoctorNAmeapp = doctorNAmeapp;
		PatientNAmeApp = patientNAmeApp;
		DateApp = dateApp;
	}
   
}
