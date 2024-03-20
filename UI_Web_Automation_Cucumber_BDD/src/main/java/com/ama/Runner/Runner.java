package com.ama.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features  = "classpath:/features", 
		glue      = "com.ama.step_definitions", 
		dryRun    = false, 
		monochrome = true,

		plugin= {"usage",				
				"html:target/cucumber-reports/report.html"
				
								}
		)
public class Runner {

}
