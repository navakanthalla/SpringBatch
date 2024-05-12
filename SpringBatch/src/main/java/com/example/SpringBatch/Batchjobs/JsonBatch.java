package com.example.SpringBatch.Batchjobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.SpringBatch.POJO.EmployeeJson;
import com.example.SpringBatch.Readers.JsonReader;
import com.example.SpringBatch.Writers.JsonWriter;

@Configuration
public class JsonBatch {
	
	@Autowired
	JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	JsonReader jsonReader;
	
	@Autowired
	JsonWriter jsonWriter;

	@Bean
	 Job jsonJob()
	{
		return jobBuilderFactory.get("jsonJob").start(jsonStep()).build();
	}


	private Step jsonStep() {
		// TODO Auto-generated method stub
		return stepBuilderFactory.get("jsonStep").<EmployeeJson,EmployeeJson>chunk(1).reader(jsonReader.JsonItemReader()).writer(jsonWriter).build();
	}
}
