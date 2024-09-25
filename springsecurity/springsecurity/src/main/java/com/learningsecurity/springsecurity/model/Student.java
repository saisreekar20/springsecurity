package com.learningsecurity.springsecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private int rollNo;
    private String firstName;
    private String lastName;
    private String marks;
}
