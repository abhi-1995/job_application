package com.jobapplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> findAll() {
        return jobService.getAllJobs();
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job request) {
        jobService.createJob(request);
        return new ResponseEntity<>("Data Inserted successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobDetailsByID(@PathVariable("id") Long id) {
        Job job = jobService.getJobById(id);
        if(job!=null) return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{job_id}")
    public ResponseEntity<String> updateJobDetails(@PathVariable("job_id") Integer job_id, @RequestBody Job request) {
        boolean isUpdate = jobService.updateJobDetailsById(job_id.longValue(), request);
        if(isUpdate) {
            return new ResponseEntity<>("Job details updated successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobDetails(@PathVariable("id") Long id) {
        boolean isDeleted = jobService.deleteJobById(id);
        if(isDeleted) return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
