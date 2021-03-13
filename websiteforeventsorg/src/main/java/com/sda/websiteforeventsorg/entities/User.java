package com.sda.websiteforeventsorg.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;

    @OneToOne(mappedBy = "user")
    private Event event;

    @OneToMany(mappedBy = "user")
    private List<Participation> participationList;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Comment> commentList;
}
