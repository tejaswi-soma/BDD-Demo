package com.example.cucumberRestApi;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", plugin = { "pretty", "json:target/cucumber.json",
		"html:target/cucumber-reports" }, monochrome = true)

public class RunnerFile_employee_Test {

	
	
	}
	 

