package com.example.SpringBatch.Writers;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.stereotype.Component;

import com.example.SpringBatch.POJO.EmployeeCsv;

@Component
public class CsvItemWriter implements ItemWriter<EmployeeCsv> {

	@Override
	public void write(List<? extends EmployeeCsv> items) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("in writer");
		items.stream().forEach(System.out::print);
		System.out.println("exiting writer");
	}

}
