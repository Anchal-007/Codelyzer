package com.eduthrill.codelyser.Entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

//@Data
@Entity
@Table(name = "Category")
public class Category {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  long category_id;
	  @Column(name="description")
	  String description;
	  @Column(name="title")
	  String title;
	  @OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	  @JsonIgnore
	  private Set<Quiz> quizzes=new LinkedHashSet<>();

	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(Set<Quiz> quizzes) {
		this.quizzes = quizzes;
	}
}
