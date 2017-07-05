package com.rean.scheduler.model;

/**
 * Class represents hourly recurrence data.
 * 
 * @author tahir
 *
 */
public class HourlyRecurrence extends RecurrenceData {
	private int everyNHrs;

	public HourlyRecurrence() {
		super(RecurrenceType.Hourly);
	}

	public int getEveryNHrs() {
		return everyNHrs;
	}

	public void setEveryNHrs(int everyNHrs) {
		this.everyNHrs = everyNHrs;
	}

	@Override
	public String toString() {
		return "HourlyRecurrence [everyNHrs=" + everyNHrs + ", getType()="
				+ getType() + ", isStartNow()=" + isStartNow()
				+ ", getStartAt()=" + getStartAt() + ", isNeverEnd()="
				+ isNeverEnd() + ", getEndAfterNOccurrences()="
				+ getEndAfterNOccurrences() + ", getEndOn()=" + getEndOn()
				+ "]";
	}

}
