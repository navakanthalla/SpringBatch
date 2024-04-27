package com.example.SpringBatch.Readers;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class ItemReaderImpl implements ItemReader<String>{
	
	List<String> aList=Arrays.asList("abc","def");
	int i=0;

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		System.out.println("In item reader");
		if(aList==null || i>=aList.size())
			return null;
		else
		{
		return aList.get(i++);
		}
	}
	

}
