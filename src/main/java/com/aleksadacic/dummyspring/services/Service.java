package com.aleksadacic.dummyspring.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface Service<T> {

    T save(T entity);

    List<T> findAll();

    Optional<T> findById(Long id);

    T update(Long id, T entity);

    void deleteById(Long id);

    // New methods for Specifications, Sorting, and Pagination
    List<T> findAll(Specification<T> specification);

    List<T> findAll(Specification<T> specification, Sort sort);

    Page<T> findAll(Specification<T> specification, Pageable pageable);

    Page<T> findAll(Pageable pageable);
}
