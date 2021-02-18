package com.swamicodes.springbootconfig;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	@Value("${my.greetings}")
	private String myGreetings;

	@Value("Some Static Message")
	private String appName;

	@Value("${app.description: Default Value}")
	private String appDescription;

	@Value("${my.list.values}")
	private List<String> listValues;

	@Value("#{${db.connection}}")
	private Map<String, String> dbValues;

	@Autowired
	private DbSettings dbSettings;

	@GetMapping("/greetings")
	public String greetings() {

		return myGreetings + appName + appDescription + listValues + dbValues;
	}

	@GetMapping("/db")
	public String dbSettings() {
		return dbSettings.getConnection() + dbSettings.getHost() + dbSettings.getPort();
	}

}
