package com.jobhub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jobhub.model.Vacancy;
import com.jobhub.repository.VacancyRepository;
import com.jobhub.service.VacancyService;

@SpringBootTest
public class VacancyServiceTest {

    @Autowired
    private VacancyService vacancyService;

    @Test
    public void testCreateVacancy() {
        Vacancy vacancy = new Vacancy();

        vacancy.setTitle("Software Engineer");
        vacancy.setCompanyName("Tech Company");
        vacancy.setLocation("New York");
        vacancy.setSalary(100000.0);
        vacancy.setRemote(true);
        vacancy.getTechnologies().add("Java");

        Vacancy saved = vacancyService.createVacancy(vacancy);
        
        assertNotNull(saved.getId());
    }
    @Autowired
    private VacancyRepository vacancyRepository;

    @Test
    public void testGetVacancyById() {
        Vacancy vacancy = new Vacancy();
        vacancy.setTitle("Desenvolvedor Java");

        Vacancy savedVacancy = vacancyRepository.saveAndFlush(vacancy); 

        Long id = savedVacancy.getId();

        Vacancy result = vacancyService.findById(id);

        assertNotNull(result);
    }

    @Test
    public void testUpdateVacancy() {
        Vacancy vacancy = new Vacancy();
        vacancy.setTitle("Desenvolvedor Java");
        vacancy.setCompanyName("Tech Company");

        vacancy = vacancyRepository.saveAndFlush(vacancy);
        Long id = vacancy.getId();

        Vacancy found = vacancyService.findById(id);
        assertNotNull(found);

        found.setTitle("Desenvolvedor Python");

        vacancyRepository.save(found);

        assertEquals("Desenvolvedor Python", found.getTitle());
    }

}
