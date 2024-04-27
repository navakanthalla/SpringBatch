package com.example.SpringBatch.Controller;

import java.util.HashMap;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobStartingController {
	
	@Autowired
	JobLauncher jobLauncher;
	
	//@Qualifier("firstJob")
	@Autowired
	Job firstJob;
	
	@GetMapping("/firstJob")
	public ResponseEntity<Object> startFirstJob() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException
	{
		
		HashMap<String, JobParameter> paramsHashMap=new HashMap<String, JobParameter>();
		paramsHashMap.put("time",new JobParameter(System.currentTimeMillis()));
		JobParameters jobParameters=new JobParameters(paramsHashMap);
		jobLauncher.run(firstJob, jobParameters);
		
		return new ResponseEntity<Object>("job started",HttpStatus.CREATED);
	}

}
