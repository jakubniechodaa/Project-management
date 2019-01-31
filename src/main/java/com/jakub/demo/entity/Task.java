package com.jakub.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String subject;

    @NotNull
    @OneToOne
    private Project project;

    @NotNull
    private String description;

    @OneToOne
    @NotNull
    private Status status;

    @NotNull
    @OneToOne
    private User user;

    private Date date = new Date(Calendar.getInstance().getTime().getTime());

}
