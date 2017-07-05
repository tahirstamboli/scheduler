package com.rean.scheduler.model;

/**
 * Class represents one time recurrence data.
 * 
 * @author tahir
 *
 */
public class OneTimeRecurrence extends RecurrenceData {

	public OneTimeRecurrence() {
		super(RecurrenceType.Once);
	}

	@Override
	public String toString() {
		return "OneTimeRecurrence [getType()=" + getType() + ", isStartNow()="
				+ isStartNow() + ", getStartAt()=" + getStartAt()
				+ ", isNeverEnd()=" + isNeverEnd()
				+ ", getEndAfterNOccurrences()=" + getEndAfterNOccurrences()
				+ ", getEndOn()=" + getEndOn() + "]";
	}

	
}
