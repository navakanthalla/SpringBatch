package com.example.SpringBatch.Writers;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class ItemWriterImpl implements ItemWriter<String>{

	@Override
	public void write(List<? extends String> items) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("in item writer");
		items.stream().forEach(System.out::println);
	}

}
