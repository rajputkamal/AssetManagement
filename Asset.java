package com.dto;

public class Asset {
	private String name;
	private String purDate;
	private String conNote;
	private String category;
	private String status;

	public Asset() {

	}

	public Asset(String name, String purDate, String conNote, String category, String status) {
		this.name = name;
		this.purDate = purDate;
		this.conNote = conNote;
		this.category = category;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPurDate() {
		return purDate;
	}

	public void setPurDate(String purDate) {
		this.purDate = purDate;
	}

	public String getConNote() {
		return conNote;
	}

	public void setConNote(String conNote) {
		this.conNote = conNote;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}