package com.brightcove.hls;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@SpringBootApplication
@RestController
public class DemoApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String hello() {
		return "Hello World from Tomcat";
	}

	@RequestMapping(value = "/healthcheck")
	public String healthcheck() {
		return "200";
	}

	@RequestMapping(value = "/metadata/{id}")
	@ResponseBody
	public String metadata(@PathVariable("id") String id) throws IOException {
		try {
			String path = "C:\\Users\\Zachary\\Documents\\fabric-hls-coding-exercise\\fabric-hls-coding-exercise\\cucumber\\fixtures\\";
			File file = new File(path.concat(id.concat(".json")));
			String data = FileUtils.readFileToString(file, "UTF-8");
			return ComputeDuration(data);
		} catch (FileNotFoundException e) {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "entity not found");		
		}
	}
	/**
	 * adds up all the numeric values for the duration keys inside an object called 'atoms'
	 * total duration for simple.json is 22284
	 * @param Json
	 * @return String
	 */
	private String ComputeDuration(String Json) {
		JsonObject jsonObject = new Gson().fromJson(Json, JsonObject.class);
		JsonArray atoms = (JsonArray) jsonObject.get("atoms");
		Integer totalDuration = 0;
		for(int i = 0; i < atoms.size(); i++) {
			JsonElement duration = atoms.get(i).getAsJsonObject().get("duration");
			totalDuration += duration.getAsInt();
		}
		return totalDuration.toString();
	}
}
