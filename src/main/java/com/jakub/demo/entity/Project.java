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
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @NotNull
    private String description;

    @NotNull
    @URL
    private String website;


    @ManyToMany(mappedBy = "projects")
    private Set<User> users = new HashSet<>();;

    private boolean active = true;

    private Date date = new Date(Calendar.getInstance().getTime().getTime());

    private String generateId(String name){
        String generated = name;
        generated = generated.replace("ą","");
        generated = generated.replace("Ą","");
        generated = generated.replace("ć","");
        generated = generated.replace("Ć","");
        generated = generated.replace("ę","");
        generated = generated.replace("Ę","");
        generated = generated.replace("ń","");
        generated = generated.replace("Ń","");
        generated = generated.replace("ó","");
        generated = generated.replace("Ó","");
        generated = generated.replace("ł","");
        generated = generated.replace("Ł","");
        generated = generated.replace("ż","");
        generated = generated.replace("Ż","");
        generated = generated.replace("ź","");
        generated = generated.replace("Ź","");
        generated = generated.replace(" ","-");
        return generated;
    }

}
