package com.example.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class DepartmentsController {

    @Autowired // AUTOMATYCZNE LACZENIE Z BAZĄ -> APLICATION PROPERTIES

    // SKLADNIA BARDZIEJ PREFEROWANA NIZ @AUTOWIRED
    // public DepartmentsController(DepartmentsRepository departmentsRepository){
    // this.departmentsRepository = departmentsRepository;
    // }

    // Sam Spring za nas generuje klasę, która będzie implementowała dany interfejs,
    // ponieważ mamy do czynienia z magią


    private DepartmentsRepository departmentsRepository;

    @GetMapping("/departments")
    public String list(ModelMap map){
        map.put("departments",                         // wstaw do zmiennej employees
                departmentsRepository.findAll());       // tekst o niniejszej treści

        return "list";
    }

//    @GetMapping("/departments/30")
//    public String list2(List<String>map){
//        Iterable<Integer> a= Collections.singleton(30);
//        map.add("departments",
//                departmentsRepository.findAllById(a));
//
//        return "list";
//    }
}