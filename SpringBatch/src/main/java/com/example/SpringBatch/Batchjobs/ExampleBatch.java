package com.example.SpringBatch.Batchjobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.SpringBatch.Readers.ItemReaderImpl;
import com.example.SpringBatch.Writers.ItemWriterImpl;

@Configuration
public class ExampleBatch {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private ItemReaderImpl itemReaderImpl;

	@Autowired
	private ItemWriterImpl itemWriterImpl;

	@Bean
	Job firstJob(Step second) {
		return jobBuilderFactory.get("firstJob").incrementer(new RunIdIncrementer()).start(secondStep()).build();

	}

	@Bean
//	@StepScope
	public Step secondStep() {
		return stepBuilderFactory.get("first chunk").<String, String>chunk(1).reader(itemReaderImpl)
				.writer(itemWriterImpl).build();
	}


	public Step firstStep() {
		return stepBuilderFactory.get("first Step").tasklet(firstTask()).build();
	}

	private Tasklet firstTask() { // TODO Auto-generated method stub return
		return new Tasklet() {
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println("first tasklet");
				return RepeatStatus.FINISHED;
			}
		};
	}
}
