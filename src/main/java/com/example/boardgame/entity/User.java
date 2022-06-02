package com.example.boardgame.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(name = "birthday")
    private LocalDate birth;

    @Column(name = "cell_phone", nullable = false, length = 20)
    private String cellPhone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "enum('FEMALE', 'MALE')")
    private Gender gender;

}
enum Gender{
    FEMALE,
    MALE
}
