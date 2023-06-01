package com.eduthrill.codelyser.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int result_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private User user;
    private String username;

    private int questions_attempted;
    private int total_questions;

    private int correct_answers;

    private double marks_scored;

    private String submit_date_time;
}
