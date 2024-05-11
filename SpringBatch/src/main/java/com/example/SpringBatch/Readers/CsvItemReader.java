package com.example.SpringBatch.Readers;

import java.io.File;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.example.SpringBatch.POJO.EmployeeCsv;

@Component
public class CsvItemReader {

	public FlatFileItemReader<EmployeeCsv> flatFileItemReader()
	{
		FlatFileItemReader<EmployeeCsv> flatFileItemReader=new FlatFileItemReader<EmployeeCsv>();
		System.out.println("in flatfileItemReader");
		flatFileItemReader.setResource(new FileSystemResource(new File("C:\\Users\\navak\\git\\SpringBatch\\SpringBatch\\src\\main\\resources\\InputFile\\input.csv")));
		DefaultLineMapper<EmployeeCsv> lineMapper=new DefaultLineMapper<EmployeeCsv>();
		lineMapper.setLineTokenizer(new DelimitedLineTokenizer() {
			{
				setNames("id","name","email","place");
			}
		});
		lineMapper.setFieldSetMapper(new BeanWrapperFieldSetMapper<EmployeeCsv>() {
			{
				setTargetType(EmployeeCsv.class);
			}
		});
		flatFileItemReader.setLineMapper(lineMapper);
		System.out.println("exiting flatfileItemReader");
		return flatFileItemReader;
	}
}
