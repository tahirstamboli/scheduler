package com.rean.scheduler;

import org.quartz.SchedulerException;
import org.quartz.Trigger;

import com.rean.scheduler.core.Schedulable;
import com.rean.scheduler.model.RecurrenceData;

/**
 * This is the main interface of a Scheduler
 * 
 * @author tahir
 *
 */
public interface Scheduler {

	/**
	 * Returns a handle to the Quartz Scheduler only if produced by scheduler
	 * factory.
	 * 
	 * @return org.quartz.Scheduler
	 */
	public org.quartz.Scheduler getQuartzScheduler();

	/**
	 * Starts the <code>Scheduler</code>'s threads that fire
	 * <code>{@link Trigger}s</code>. When a scheduler is first created it is in
	 * "stand-by" mode, and will not fire triggers. The scheduler can also be
	 * put into stand-by mode by calling the <code>standby()</code> method.
	 */

	/**
	 * Returns the name of the <code>Scheduler</code>.
	 * 
	 * @return
	 * @throws SchedulerException
	 */
	public String getSchedulerName() throws SchedulerException;

	/**
	 * Starts the <code>Scheduler</code>'s threads that fire
	 * <code>{@link Trigger}s</code>. When a scheduler is first created it is in
	 * "stand-by" mode, and will not fire triggers. The scheduler can also be
	 * put into stand-by mode by calling the <code>standby()</code> method.
	 * 
	 * @throws SchedulerException
	 */
	public void start() throws SchedulerException;

	/**
	 * Temporarily halts the <code>Scheduler</code>'s firing of
	 * <code>{@link Trigger}s</code>.
	 * 
	 * <p>
	 * When <code>start()</code> is called (to bring the scheduler out of
	 * stand-by mode), trigger misfire instructions will NOT be applied during
	 * the execution of the <code>start()</code> method
	 * 
	 * @throws SchedulerException
	 */
	public void standBy() throws SchedulerException;

	/**
	 * Schedule job using <code>RecurrenceData</code>.
	 * 
	 * @param job
	 *            Job to be scheduled
	 * @param recurrenceData
	 *            recurrence data to be used for trigger
	 * @throws SchedulerException
	 */
	public void schedule(Schedulable job, RecurrenceData recurrenceData)
			throws SchedulerException;

	/**
	 * Schedule job using <code>RecurrenceData</code>.
	 * 
	 * @param jobClass
	 *            Job class to be scheduled
	 * @param recurrenceData
	 *            recurrence data to be used for trigger
	 * @throws SchedulerException
	 */
	public void schedule(Class<? extends Schedulable> jobClass,
			RecurrenceData recurrenceData) throws SchedulerException;

	/**
	 * Halts the <code>Scheduler</code>'s firing of
	 * <code>{@link Trigger}s</code>, and cleans up all resources associated
	 * with the Scheduler. Equivalent to <code>shutdown(false)</code>.
	 * 
	 * <p>
	 * The scheduler cannot be re-started.
	 * </p>
	 * 
	 * @see #shutdown(boolean)
	 */
	public void shutdown() throws SchedulerException;

	/**
	 * Halts the <code>Scheduler</code>'s firing of
	 * <code>{@link Trigger}s</code>, and cleans up all resources associated
	 * with the Scheduler.
	 * 
	 * <p>
	 * The scheduler cannot be re-started.
	 * </p>
	 * 
	 * @param waitForJobsToComplete
	 *            if <code>true</code> the scheduler will not allow this method
	 *            to return until all currently executing jobs have completed.
	 * 
	 * @see #shutdown
	 */
	public void shutdown(boolean waitForJobsToComplete)
			throws SchedulerException;
}
