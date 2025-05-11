package com.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Job;
import com.backend.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {
	
	@Autowired
	JobRepository jobRepo;
	
	@Override
	public List<Job> getAllJobs() {
		return jobRepo.findAll();
	}

	@Override
	public Job getJob(Long id) {
		Optional<Job> job = jobRepo.findById(id);
		if(job.isPresent()) {
			return job.get();
		}
		return null;
	}

	@Override
	public Boolean addJob(Job job) {
		jobRepo.save(job);
		return true;
	}

	@Override
	public Boolean updateJob(Long id, Job job) {
		Optional<Job> findJob = jobRepo.findById(id);
		if(findJob.isPresent()) {
			Job currentJob = findJob.get();
			currentJob.setTitle(job.getTitle());
			currentJob.setDescription(job.getDescription());
			currentJob.setLocation(job.getLocation());
			currentJob.setMinSalary(job.getMinSalary());
			currentJob.setMaxSalary(job.getMaxSalary());
			
			jobRepo.save(currentJob);
			return true;
		} 
		return false;
	}

	@Override
	public Boolean deleteJob(Long id) {
		Optional<Job> findJob = jobRepo.findById(id);
		if(findJob.isPresent()) {
			jobRepo.deleteById(id);
			return true;
		}
		return false;
	}

}
