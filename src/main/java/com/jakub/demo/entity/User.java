package com.jakub.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    @Size(min = 2)
    private	String	username;

    @NotNull
    @Size(min = 2)
    private	String	firstname;

    @NotNull
    @Size(min = 2)
    private	String	lastname;

    @NotNull
    @Size(min = 4)
    private	String	password;

    @Email
    @Column(unique = true)
    private	String	email;

    private	boolean	enabled = true;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
