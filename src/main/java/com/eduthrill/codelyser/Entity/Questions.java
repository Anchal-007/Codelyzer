package com.eduthrill.codelyser.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long question_id;
    private String question;
    private String answer;

    @ManyToOne(fetch=FetchType.EAGER)
    private Quiz quiz;

    private String option_1;
    private String option_2;
    private String option_3;
    private String option_4;
    private String option_5;
    private String option_6;
    private String option_7;
    private String option_8;
    private String option_9;
    private String option_10;
    private String level;
    @Transient
    private String givenAnswer;


}
