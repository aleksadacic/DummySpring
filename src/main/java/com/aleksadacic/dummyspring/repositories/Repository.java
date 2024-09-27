package com.aleksadacic.dummyspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface Repository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}
