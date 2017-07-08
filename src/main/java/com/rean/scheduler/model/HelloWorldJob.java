package com.rean.scheduler.model;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

import com.rean.scheduler.core.Schedulable;

public class HelloWorldJob implements Schedulable {

	public HelloWorldJob(){
	}
	public String getIdentifier() {
		return "HellowWorldJob";
	}

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		Object object;
		try {
			object = context.getScheduler().getContext().get("Msg");
			System.out.println(object);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hello World");
	}

}
