package com.eduthrill.codelyser.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Quiz")
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long quiz_id;
	
	@Column(name="active_status")
	boolean active=false;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
//	boolean active_status;


	@Column(name="total_marks")
	long total_marks;
	
	@Column(name="number_of_questions")
	int number_of_questions;
	
	@Column(name="title")
	String title;
	
	@Column(name="start_date")
	String date;
	
	@Column(name="end_date")
	String end_date;
	@ManyToOne(fetch=FetchType.LAZY)
	private Category category;

	@OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Questions> question=new HashSet<>();

	@OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL)
	private List<Result> results=new ArrayList<>();
	public long getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(long quiz_id) {
		this.quiz_id = quiz_id;
	}

//	public boolean isActive_status() {
//		return active_status;
//	}
//
//	public void setActive_status(boolean active_status) {
//		this.active_status = active_status;
//	}

	public long getTotal_marks() {
		return total_marks;
	}

	public void setTotal_marks(long total_marks) {
		this.total_marks = total_marks;
	}

	public int getNumber_of_questions() {
		return number_of_questions;
	}

	public void setNumber_of_questions(int number_of_questions) {
		this.number_of_questions = number_of_questions;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Questions> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Questions> question) {
		this.question = question;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}



}
