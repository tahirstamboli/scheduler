package com.rean.scheduler.util;

import java.util.Properties;

import com.rean.scheduler.model.SchedulerConfig;

/**
 * Utility class that helps scheduler module to perform some utility operations.
 * 
 * @author tahir
 *
 */
public class Utils {

	public static Properties toSchedulerProperties(SchedulerConfig config) {
		Properties props = new Properties();
		if (config == null)
			return null;
		if (config.getSchedulerName() != null
				&& config.getSchedulerName().trim().length() > 0)
			props.put(Constant.ORG_QUARTZ_SCHEDULER_INSTANCENAME,
					config.getSchedulerName());

		if (config.getSchedulerId() != null
				&& config.getSchedulerId().trim().length() > 0)
			props.put(Constant.ORG_QUARTZ_SCHEDULER_INSTANCEID,
					config.getSchedulerId());

		if (config.getThreadPoolClazz() != null
				&& config.getThreadPoolClazz().trim().length() > 0)
			props.put(Constant.ORG_QUARTZ_THREADPOOL_CLASS,
					config.getThreadPoolClazz());

		if (config.getThreadName() != null
				&& config.getThreadName().trim().length() > 0)
			props.put(Constant.ORG_QUARTZ_SCHEDULER_THREADNAME,
					config.getThreadName());

		if (config.getThreadPoolThreadCount() > 0)
			props.put(Constant.ORG_QUARTZ_THREADPOOL_THREADCOUNT,
					config.getThreadPoolThreadCount()+""); // Work around for integer type thread count. Quartz accept String type value.

		if (props.size() > 0)
			return props;

		return null;

	}
}
