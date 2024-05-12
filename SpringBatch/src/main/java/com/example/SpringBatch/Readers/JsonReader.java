package com.example.SpringBatch.Readers;

import java.io.File;

import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.example.SpringBatch.POJO.EmployeeJson;

@Component
public class JsonReader {

	public JsonItemReader<EmployeeJson> JsonItemReader() {
		
		JsonItemReader<EmployeeJson> jsonReader= new JsonItemReader<EmployeeJson>();
		jsonReader.setResource(new FileSystemResource(new File("C:\\Users\\navak\\git\\SpringBatch\\SpringBatch\\src\\main\\resources\\InputFile\\input.json")));
		jsonReader.setJsonObjectReader(new JacksonJsonObjectReader<EmployeeJson>(EmployeeJson.class));
		return jsonReader;
	}
}
