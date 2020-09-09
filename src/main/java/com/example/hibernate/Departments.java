package com.example.hibernate;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Entity                           // mówi, że będzie to łączone z tabelką w bazie danych
    @Table(name="DEPT")              // tak trzeba zrobić, bo w bazie nazywa się EMP
    @Setter                         // lombok
    @Getter
    @NoArgsConstructor               // tworzy pusty konstruktow

    public class Departments {

        @Column(name="DEPTNO")
        @Id                       // to będzie nasz klucz główny informujemy JAVE, że jest klucz główny
        private Integer id;

        @Column(name = "DNAME")
        private String name;

        @Column(name = "LOC")
        private String location;

//        @GetMapping("/dept/30")
//        public String show30(ModelMap map) {
//            map.put("employees", ((List<Departments>)departmentsRepository.findAll()).stream().filter(d->d.getId()==30).collect(Collectors.toList()));
//            return "list";
//        }

    @Override
    public String toString() {
        return "Departments{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", employees=" + employees +
                '}';
    }

    @OneToMany(mappedBy ="departments")
        // mapped by to jest nazwa pola z drugiej klasy - JoinColumn - klucz obcy z drugiej strony
        private List<Employee> employees = new ArrayList<>();

    }

