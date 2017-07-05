package com.rean.scheduler.core;

import java.util.Properties;

import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import com.rean.scheduler.Scheduler;
import com.rean.scheduler.core.impl.SchedulerImpl;
import com.rean.scheduler.model.SchedulerConfig;
import com.rean.scheduler.util.Utils;

/**
 * @author tahir
 *
 */
public class SchedulerFactory {

	/**
	 * <p>
	 * Returns a handle to the Scheduler produced by this factory.
	 * </p>
	 */

	public static Scheduler getScheduler() throws SchedulerException {
		org.quartz.Scheduler qScheduler = new StdSchedulerFactory()
				.getScheduler();
		Scheduler scheduler = new SchedulerImpl(qScheduler);
		return scheduler;
	}

	/**
	 * <p>
	 * Returns a handle to the Scheduler with the given configuration.
	 * </p>
	 */
	public static Scheduler getScheduler(SchedulerConfig config)
			throws SchedulerException {
		org.quartz.Scheduler qScheduler = null;
		Properties schedulerProperties = Utils.toSchedulerProperties(config);
		if (schedulerProperties == null) {
			qScheduler = new StdSchedulerFactory().getScheduler();
		} else {
			qScheduler = new StdSchedulerFactory(schedulerProperties)
					.getScheduler();
		}
		Scheduler scheduler = new SchedulerImpl(qScheduler);
		return scheduler;
	}

}
