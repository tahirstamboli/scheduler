package com.rean.scheduler.model;

/**
 * Enum defines recurrence type for scheduler to scheduler provided job.
 * 
 * @author tahir
 *
 */
public enum RecurrenceType {
	Once, Hourly, Daily, Weekly, Monthly;

	/**
	 * Check if given recurrence type is member of supported recurrence types.
	 * 
	 * @param recurrenceType
	 * @return
	 */
	static public boolean isMember(String recurrenceType) {
		RecurrenceType[] types = RecurrenceType.values();
		for (RecurrenceType type : types)
			if (type.name().equals(recurrenceType))
				return true;
		return false;
	}
}
