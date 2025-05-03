package com.backend.job.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.job.model.Job;


public interface JobRepository extends JpaRepository<Job, Long> {

	Optional<Job> findByLocation(String location);
	

}
