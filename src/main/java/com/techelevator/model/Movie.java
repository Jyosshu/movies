package com.techelevator.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

public class Movie {
	private Long id;
	
	@NotBlank(message="Title is a required field")
	private String title;
	
	@NotNull(message="# of copies cannot be Null")
	@Min(value=0, message="# of copies cannot be less than 0")
	@Max(value=100, message="# of copies cannot be larger than 100")
	private int numOfCopies;
	
	@NotNull(message="# of copies available cannot be Null")
	@Min(value=0, message="# of copies available cannot be less than 0")
	@Max(value=100, message="# of copies available cannot be larger than 100")
	private int availableCopies;
	
	@NotNull(message="Release date cannot be NULL")
	@Past(message="Release date must be before today")
	private LocalDateTime releaseDate;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumOfCopies() {
		return numOfCopies;
	}
	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}
	public int getAvailableCopies() {
		return availableCopies;
	}
	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}
	public LocalDateTime getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDateTime releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getFormatedDate() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
	    String formatDateTime = releaseDate.format(format);   
		return formatDateTime;
	}
}
