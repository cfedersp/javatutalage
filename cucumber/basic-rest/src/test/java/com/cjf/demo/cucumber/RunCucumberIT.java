package com.cjf.demo.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, tags = "@HelloWorld and not @Pending", features="src/test/resources/bdd/")
public class RunCucumberIT {
	// Cucumber will automatically scan the classpath for Step Definitions
	//@Before @After hooks can go here
	
	

}
