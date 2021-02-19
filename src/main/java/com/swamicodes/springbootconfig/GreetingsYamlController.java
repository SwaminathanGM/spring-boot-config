package com.swamicodes.springbootconfig;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("yml")
public class GreetingsYamlController {


	@Value("${our.greetings}")
	private String myGreetings;

	@Value("${service.name}")
	private String appName;

	@Value("${service.description: Default Value}")
	private String appDescription;

	@Value("${our.list.values}")
	private List<String> listValues;

	@Value("#{${database.connection}}")
	private Map<String, String> dbValues;

	@Autowired
	private DbSettingsYml dbSettingsYml;

	@GetMapping("/greetings")
	public String greetings() {

		return myGreetings + appName + appDescription + listValues + dbValues;
	}

	@GetMapping("/db")
	public String dbSettings() {
		return dbSettingsYml.getConnection() + dbSettingsYml.getHost() + dbSettingsYml.getPort();
	}



}
