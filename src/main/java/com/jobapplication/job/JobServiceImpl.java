package com.jobapplication.job;

import com.jobapplication.Job;
import com.jobapplication.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class JobServiceImpl implements JobService {
    private final List<Job> jobList;
    public JobServiceImpl(List<Job> jobList) {
        this.jobList = jobList;
    }

    private Long id = 1L;

    @Override
    public void createJob(Job job) {
        job.setId(id++);
        jobList.add(job);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobList;
    }

    @Override
    public Job getJobById(Long id) {
        for (Job job : jobList) {
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean updateJobDetailsById(Long id, Job updatedJob) {
        Job job = getJobById(id);
        if(job!=null){
            if(nonNull(updatedJob.getTitle())) job.setTitle(updatedJob.getTitle());
            if(nonNull(updatedJob.getMaxSalary())) job.setMaxSalary(updatedJob.getMaxSalary());
            if(nonNull(updatedJob.getMinSalary())) job.setMinSalary(updatedJob.getMinSalary());
            if(nonNull(updatedJob.getLocation())) job.setLocation(updatedJob.getLocation());
            if(nonNull(updatedJob.getDescription())) job.setDescription(updatedJob.getDescription());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteJobById(Long id) {
        Iterator<Job> iterator = jobList.iterator();
        while(iterator.hasNext()) {
            Job job = iterator.next();
            if(job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
