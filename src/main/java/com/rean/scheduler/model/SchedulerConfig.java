package com.rean.scheduler.model;

/**
 * These class configure the identification of the scheduler, and various other
 * ‘top level’ settings.
 * 
 * @author tahir
 *
 */
public class SchedulerConfig {

	/* org.quartz.scheduler.instanceName */
	private String schedulerName;

	/* org.quartz.scheduler.instanceId */
	private String schedulerId;

	/* org.quartz.threadPool.class */
	private String threadPoolClazz = "org.quartz.simpl.SimpleThreadPool";

	/* org.quartz.scheduler.threadName */
	private String threadName;

	/* org.quartz.threadPool.threadCount */
	private int threadPoolThreadCount = 10;

	public String getSchedulerName() {
		return schedulerName;
	}

	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}

	public String getSchedulerId() {
		return schedulerId;
	}

	public void setSchedulerId(String schedulerId) {
		this.schedulerId = schedulerId;
	}

	public String getThreadPoolClazz() {
		return threadPoolClazz;
	}

	public void setThreadPoolClazz(String threadPoolClazz) {
		this.threadPoolClazz = threadPoolClazz;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public int getThreadPoolThreadCount() {
		return threadPoolThreadCount;
	}

	public void setThreadPoolThreadCount(int threadPoolThreadCount) {
		this.threadPoolThreadCount = threadPoolThreadCount;
	}

}
