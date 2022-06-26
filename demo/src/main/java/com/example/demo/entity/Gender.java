package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(name = "gender")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gender
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String genderName;
}