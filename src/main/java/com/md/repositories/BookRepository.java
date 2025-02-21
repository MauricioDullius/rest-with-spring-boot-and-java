package com.md.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.md.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}