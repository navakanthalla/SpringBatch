package com.example.SpringBatch.Batchjobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.SpringBatch.POJO.EmployeeCsv;
import com.example.SpringBatch.Readers.CsvItemReader;
import com.example.SpringBatch.Writers.CsvItemWriter;

@Configuration
public class CsvBatch {
	
	@Autowired
	JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	CsvItemReader csvItemReader;

	@Autowired
	CsvItemWriter csvItemWriter;
	@Bean
	Job csvJob()
	{
		return jobBuilderFactory.get("csvJob").incrementer(new RunIdIncrementer()).start(csvStep()).build();
	}
	
	public Step csvStep()
	{
		return stepBuilderFactory.get("csvStep").<EmployeeCsv,EmployeeCsv>chunk(3).reader(csvItemReader.flatFileItemReader()).writer(csvItemWriter).build();	
	}
}
