package com.rean.scheduler.model;

/**
 * Class represents monthly recurrence data.
 * 
 * @author tahir
 *
 */
public class MonthlyRecurrence extends RecurrenceData {
	private int everyNMonths;

	public MonthlyRecurrence() {
		super(RecurrenceType.Monthly);
	}

	public int getEveryNMonths() {
		return everyNMonths;
	}

	public void setEveryNMonths(int everyNMonths) {
		this.everyNMonths = everyNMonths;
	}

	@Override
	public String toString() {
		return "MonthlyRecurrence [everyNMonths=" + everyNMonths
				+ ", getType()=" + getType() + ", isStartNow()=" + isStartNow()
				+ ", getStartAt()=" + getStartAt() + ", isNeverEnd()="
				+ isNeverEnd() + ", getEndAfterNOccurrences()="
				+ getEndAfterNOccurrences() + ", getEndOn()=" + getEndOn()
				+ "]";
	}

	
}
