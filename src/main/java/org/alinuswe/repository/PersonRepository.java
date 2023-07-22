package org.alinuswe.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.alinuswe.model.Person;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
}
