package com.jobhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jobhub.model.Vacancy;
import com.jobhub.service.VacancyService;

@RestController
@RequestMapping("/vacancies")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;
    
    @GetMapping
    public List<Vacancy> getAllVacancies() {
        return vacancyService.findAll();
    }

    @PostMapping
    public Vacancy createVacancy(@RequestBody Vacancy vacancy) {
        return vacancyService.createVacancy(vacancy);
    }

    @GetMapping("/id")
    public Vacancy getVacancyById(@RequestParam Long id) {
        return vacancyService.findById(id);
    }

    @PutMapping("/id")
    public Vacancy updateVacancy(@RequestParam Long id, @RequestBody Vacancy vacancy) {
        return vacancyService.updateVacancy(id, vacancy);
    }

    @GetMapping("/search")
    public List<Vacancy> search(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String company,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Double minSalary,
            @RequestParam(required = false) Boolean remote,
            @RequestParam(required = false) String technology
    ) {
        return vacancyService.searchWithFilters(title, company, location, minSalary, remote, technology);
    }
}
