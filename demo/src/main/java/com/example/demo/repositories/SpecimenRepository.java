package com.example.demo.repositories;

import com.example.demo.model.Specimen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface SpecimenRepository extends JpaRepository<Specimen, UUID> { }