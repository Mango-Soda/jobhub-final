package com.jobhub.specification;

import com.jobhub.model.Vacancy;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class VacancySpecification {

    public static Specification<Vacancy> withFilters(String title, String company, String location, Double minSalary, Boolean remote, String technology) {
        return (root, query, cb) -> {
            Predicate predicate = cb.conjunction();

            if (title != null && !title.isEmpty()) {
                predicate = cb.and(predicate, cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%"));
            }

            if (company != null && !company.isEmpty()) {
                predicate = cb.and(predicate, cb.like(cb.lower(root.get("companyName")), "%" + company.toLowerCase() + "%"));
            }

            if (location != null && !location.isEmpty()) {
                predicate = cb.and(predicate, cb.like(cb.lower(root.get("location")), "%" + location.toLowerCase() + "%"));
            }

            if (minSalary != null) {
                predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.get("salary"), minSalary));
            }

            if (remote != null) {
                predicate = cb.and(predicate, cb.equal(root.get("remote"), remote));
            }

           
            if (technology != null && !technology.isEmpty()) {
                Join<Object, Object> techJoin = root.join("technologies");
                predicate = cb.and(predicate, cb.like(cb.lower(techJoin.get("name")), "%" + technology.toLowerCase() + "%"));
            }

            return predicate;
        };
    }
}