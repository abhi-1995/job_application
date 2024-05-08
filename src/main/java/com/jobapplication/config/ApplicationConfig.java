package com.jobapplication.config;

import com.jobapplication.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationConfig {

    private final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

    @Bean
    public List<Job> jobList() {
        logger.info("Initializing application configuration of jobs application ");
        List<Job> jobList = new ArrayList<>();
        logger.info("Initialization done ............");
        return jobList;
    }
}
