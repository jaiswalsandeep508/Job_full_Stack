package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.model.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

}
