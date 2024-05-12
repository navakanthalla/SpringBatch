package com.example.SpringBatch.Writers;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.example.SpringBatch.POJO.EmployeeJson;

@Component
public class JsonWriter implements ItemWriter<EmployeeJson> {
	
	@Override
	public void write(List<? extends EmployeeJson> items) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("in writer");
		items.stream().forEach(System.out::print);
		System.out.println("exiting writer");
	}

}
 