package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "student")
@Where(clause = "deleted=false")
@Data
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    private String studentName;
    private String studentFathersName;
    private boolean deleted ;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    private Gender gender;
}