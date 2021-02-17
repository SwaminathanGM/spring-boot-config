package com.swamicodes.springbootconfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
	
	@Value("${my.greetings}")
	private String myGreetings;
	
	@Value("${app.name}")
	private String appName;
	
	@Value("${app.description}")
	private String appDescription;
	
	@GetMapping("/greetings")
	public List<String> greetings() {
		
		List<String> stringList = new ArrayList<>();
		stringList.add(myGreetings);
		stringList.add(appName);
		stringList.add(appDescription);
		return stringList;
	}

}
