package com.eduthrill.codelyser.Model;

import com.eduthrill.codelyser.Entity.Category;
import com.eduthrill.codelyser.Entity.Questions;
import com.eduthrill.codelyser.Entity.Result;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class QuizModel {

    long quiz_id;

    boolean active_status;

    long total_marks;

    int number_of_questions;

    String title;

    String date;

    String end_date;

    private Category category;

    private Set<Questions> question=new HashSet<>();

    private List<Result> results=new ArrayList<>();

    public long getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(long quiz_id) {
        this.quiz_id = quiz_id;
    }

    public boolean isActive_status() {
        return active_status;
    }

    public void setActive_status(boolean active_status) {
        this.active_status = active_status;
    }

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
