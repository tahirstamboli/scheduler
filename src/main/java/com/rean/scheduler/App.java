package com.rean.scheduler;

import java.util.Calendar;
import java.util.Date;

import org.quartz.SchedulerException;

import com.rean.scheduler.core.SchedulerFactory;
import com.rean.scheduler.model.HelloWorldJob;
import com.rean.scheduler.model.HourlyRecurrence;
import com.rean.scheduler.model.OneTimeRecurrence;
import com.rean.scheduler.model.SchedulerConfig;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) throws SchedulerException
	{
		
		// ------- One Time Schedule -------------------------
		// 1. Start Now
		HelloWorldJob j = new HelloWorldJob();
		
		OneTimeRecurrence data = OneTimeRecurrence.builder().startNow(true).build();
		Scheduler scheduler1 = SchedulerFactory.getScheduler();
		System.out.println("Scheduler Name : "+scheduler1.getQuartzScheduler().getSchedulerName());
		scheduler1.start();
		System.out.println("**** Schedule job now for one time ****");
		//scheduler.schedule(HelloWorldJob.class, data);
		scheduler1.getQuartzScheduler().getContext().put("Msg", "I Love U");
		scheduler1.schedule(j, data);
		
		// 2. Start At
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, 1);
		data = OneTimeRecurrence.builder().startNow(false).startAt(cal.getTime()).build();
		System.out.println("**** Schedule job at "+cal.getTime()+" for one time ****");
		SchedulerConfig schedulerConfig = new SchedulerConfig();
		schedulerConfig.setSchedulerName("REAN-Test");
		Scheduler scheduler2 = SchedulerFactory.getScheduler(schedulerConfig);
		System.out.println("Scheduler Name : "+scheduler2.getQuartzScheduler().getSchedulerName());
		
		scheduler2.start();
		//scheduler.schedule(HelloWorldJob.class, data);
		scheduler2.schedule(j, data);
		// ------- Hourly Schedule -------------------------
		
		// 1. Start now hourly for every 1 hr end after 2 occurrences
		HourlyRecurrence hData = HourlyRecurrence.builder().startNow(true).everyNHrs(1).endAfterNOccurrences(2).build();
		//scheduler.schedule(HelloWorldJob.class, hData);
	}
}
