package com.example.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @Autowired // AUTOMATYCZNE LACZENIE Z BAZĄ -> APLICATION PROPERTIES

    // Sam Spring za nas generuje klasę, która będzie implementowała dany interfejs,
    // ponieważ mamy do czynienia z magią

    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String list(ModelMap map){
        map.put("employees",                         // wstaw do zmiennej employees
                employeeRepository.findAll());       // tekst o niniejszej treści

        return "list";

    }
}
