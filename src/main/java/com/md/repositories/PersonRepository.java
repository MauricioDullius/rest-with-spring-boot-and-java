package com.md.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.md.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {}