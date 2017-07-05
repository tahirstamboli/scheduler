package com.rean.scheduler.model;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.rean.scheduler.core.Schedulable;

public class HelloWorldJob implements Schedulable {

	public String getIdentifier() {
		return "HellowWorldJob";
	}

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("Hello World");
	}

}
