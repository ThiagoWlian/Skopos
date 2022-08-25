package com.skopos.SkoposAPI.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "EXERCICIO")
public class ExercicioModel {
	@Id
	private long id;
	private String sport_type;
	private String distance;
	private String moving_time;
	private Date start_date_local;
	
	@ManyToOne
	private PessoaModel pessoa;
	
	public ExercicioModel() {}
	
	public ExercicioModel(long id, String sport_type, String distance, String moving_time, String start_date_local) throws ParseException {
		this.id = id;
		this.sport_type = sport_type;
		this.distance = distance;
		this.moving_time = moving_time;
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf1.parse(start_date_local);
		this.start_date_local = new java.sql.Date(date.getTime()); 
	}
	
	public ExercicioModel(String sport_type, String distance, String moving_time, String start_date_local) throws ParseException {
		this.sport_type = sport_type;
		this.distance = distance;
		this.moving_time = moving_time;
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf1.parse(start_date_local);
		this.start_date_local = new java.sql.Date(date.getTime()); 
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSport_type() {
		return sport_type;
	}
	public void setSport_type(String sport_type) {
		this.sport_type = sport_type;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getMoving_time() {
		return moving_time;
	}
	public void setMoving_time(String moving_time) {
		this.moving_time = moving_time;
	}
	public Date getStart_date_local() {
		return start_date_local;
	}
	public void setStart_date_local(String start_date_local) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf1.parse(start_date_local);
		this.start_date_local = new java.sql.Date(date.getTime()); 
	}
	public PessoaModel getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaModel pessoa) {
		this.pessoa = pessoa;
	}
}
