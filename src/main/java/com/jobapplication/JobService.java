package com.jobapplication;

import java.util.List;

public interface JobService {

    void createJob(Job job);
    List<Job> getAllJobs();
    Job getJobById(Long id);
    boolean updateJobDetailsById(Long id, Job job);
    boolean deleteJobById(Long id);
}
