package com.example.AOPTask.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Email
    private String email;
    @NumberFormat
    private String phone;
    private int experience;
    @Column(length = 2000)
    private String resumeText;

}
