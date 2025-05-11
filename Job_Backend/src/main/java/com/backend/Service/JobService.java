package com.backend.Service;

import java.util.List;
import com.backend.model.Job;

public interface JobService {
	List<Job> getAllJobs();
	Job getJob(Long id);
	Boolean addJob(Job job);
	Boolean updateJob(Long id, Job job);
	Boolean deleteJob(Long id);
}
