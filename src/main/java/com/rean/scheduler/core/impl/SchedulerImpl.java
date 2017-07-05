package com.rean.scheduler.core.impl;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

import com.rean.scheduler.Scheduler;
import com.rean.scheduler.core.RecurrenceTriggerBuilder;
import com.rean.scheduler.core.RecurrenceValidator;
import com.rean.scheduler.core.Schedulable;
import com.rean.scheduler.model.RecurrenceData;

/**
 * 
 * <p>
 * Returns a handle to the Scheduler produced by scheduler factory.
 * </p>
 * 
 * @author tahir
 *
 */
public class SchedulerImpl implements Scheduler {
	private org.quartz.Scheduler scheduler;

	public SchedulerImpl(org.quartz.Scheduler qScheduler) {
		this.scheduler = qScheduler;
	}

	/**
	 * {@inheritDoc}
	 */
	public org.quartz.Scheduler getQuartzScheduler() {
		return this.scheduler;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getScheulerName() throws SchedulerException {
		return this.scheduler.getSchedulerName();
	}

	/**
	 * {@inheritDoc}
	 */
	public void start() throws SchedulerException {
		scheduler.start();
	}

	/**
	 * {@inheritDoc}
	 */
	public void standBy() throws SchedulerException {
		scheduler.standby();
	}

	/**
	 * {@inheritDoc}
	 */
	public void schedule(Schedulable job, RecurrenceData recurrenceData)
			throws SchedulerException {
		// Validation of recurrence data
		RecurrenceValidator.validate(recurrenceData);

		// Proper Trigger creation for recurrence data
		Trigger trigger = RecurrenceTriggerBuilder.newTrigger()
				.withRecurrence(recurrenceData).build();

		// Quartz Job from schedulable
		JobDetail jobDetail = JobBuilder.newJob(job.getClass()).build();

		// Trigger job schedule
		scheduler.scheduleJob(jobDetail, trigger);
	}

	/**
	 * {@inheritDoc}
	 */
	public void schedule(Class<? extends Schedulable> jobClass,
			RecurrenceData recurrenceData) throws SchedulerException {
		// Validation of recurrence data
		RecurrenceValidator.validate(recurrenceData);

		// Proper Trigger creation for recurrence data
		Trigger trigger = RecurrenceTriggerBuilder.newTrigger()
				.withRecurrence(recurrenceData).build();

		// Quartz Job from schedulable
		JobDetail jobDetail = JobBuilder.newJob(jobClass).build();

		// Trigger job schedule
		scheduler.scheduleJob(jobDetail, trigger);
	}

	/**
	 * {@inheritDoc}
	 */
	public void shutdown() throws SchedulerException {
		scheduler.shutdown();

	}

	/**
	 * {@inheritDoc}
	 */
	public void shutdown(boolean waitForJobsToComplete)
			throws SchedulerException {
		scheduler.shutdown(waitForJobsToComplete);
	}

}
