package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Info {
	
	private LocalDate firstDay;
	private LocalDate lastDay;
	private float tot;
	private float media;
	public Info(LocalDate firstDay, LocalDate lastDay, float tot, float media) {
		super();
		this.firstDay = firstDay;
		this.lastDay = lastDay;
		this.tot = tot;
		this.media = media;
	}
	public LocalDate getFirstDay() {
		return firstDay;
	}
	public void setFirstDay(LocalDate firstDay) {
		this.firstDay = firstDay;
	}
	public LocalDate getLastDay() {
		return lastDay;
	}
	public void setLastDay(LocalDate lastDay) {
		this.lastDay = lastDay;
	}
	public float getTot() {
		return tot;
	}
	public void setTot(float tot) {
		this.tot = tot;
	}
	public float getMedia() {
		return media;
	}
	public void setMedia(float media) {
		this.media = media;
	}
	
	

}
