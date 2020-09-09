package com.example.hibernate;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity                          // mówi, że będzie to łączone z tabelką w bazie danych
@Table (name="EMP")              // tak trzeba zrobić, bo w bazie nazywa się EMP
@Setter                           // lombok
@Getter
@NoArgsConstructor               // tworzy pusty konstruktow

public class Employee {

    @Column(name="EMPNO")
    @Id                          // to będzie nasz klucz główny informujemy JAVE, że jest klucz główny
    private Integer id;

    @Column(name = "ENAME")
    private String name;

    @Column(name="JOB")
    private String job;

    @ManyToOne
    @JoinColumn(name = "DEPTNO")
    private Departments departments;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", departments=" + departments.getName() +
                '}';
    }
}
