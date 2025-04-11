package com.jobhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobhub.model.Vacancy;
import com.jobhub.repository.VacancyRepository;
import com.jobhub.specification.VacancySpecification;

@Service
public class VacancyService {

    @Autowired
    VacancyRepository repo; 

    public List<Vacancy> findAll() {
        return repo.findAll();
    }

    public Vacancy createVacancy(Vacancy vacancy) {
        if (vacancy == null) {
            throw new IllegalArgumentException("Vacancy cannot be null");
        }
        return repo.save(vacancy);
    }

    public Vacancy findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Vacancy updateVacancy(Long id, Vacancy vacancy) {
        if (id == null || vacancy == null) {
            throw new IllegalArgumentException("Id and Vacancy cannot be null");
        }
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Vacancy with Id " + id + " does not exist");
        }
        vacancy.setId(id);
        return repo.save(vacancy);
    }

    public void deleteVacancy(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Vacancy with Id " + id + " does not exist");
        }
        repo.deleteById(id);
    }

    public List<Vacancy> searchWithFilters(String title, String company, String location, Double minSalary, Boolean remote, String technology) {
        return repo.findAll(VacancySpecification.withFilters(title, company, location, minSalary, remote, technology));
        
    }
}
