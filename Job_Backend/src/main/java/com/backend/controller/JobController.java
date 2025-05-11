package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Service.JobService;
import com.backend.model.Job;

@RestController
@RequestMapping("/jobs")
public class JobController {
	
	@Autowired
	JobService jobService;
	
	@GetMapping
	private List<Job> getAllJobs(){
		return jobService.getAllJobs();
	}
	
//	@GetMapping("/{id}")
//	private ResponseEntity<Object> getJob(@PathVariable Long id) {
//		Job job = jobService.getJob(id); 
//		if (job != null) {
//	        return ResponseEntity.ok(job);
//	    } else {
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job not Found..😢");
//	    }
//	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Object> getJob(@PathVariable Long id) {
		Job job = jobService.getJob(id); 
		if (job != null) {
	        return ResponseEntity.ok(job);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job not Found..😢");
	    }
	}
	
	@PostMapping
	private String addJob(@RequestBody Job job) {
		return jobService.addJob(job)? "Job Added Successfully...😊" : "Job Not Added....😢";
	}
	
	@PutMapping("{id}")
	private ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Job job){
		return jobService.updateJob(id, job)? new ResponseEntity<>("Job updated...❤", HttpStatus.OK) : new ResponseEntity<>("Job Not Founnd...😢",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("{id}")
	private ResponseEntity<String> deleteJob(@PathVariable Long id){
		return jobService.deleteJob(id)? new ResponseEntity<>("Job deleted...❤", HttpStatus.OK) : new ResponseEntity<>("Job Not Founnd...😢",HttpStatus.NOT_FOUND);
	}
}
