package com.rean.scheduler.model;

/**
 * Class represents daily recurrence data.
 * 
 * @author tahir
 *
 */
public class DailyRecurrence extends RecurrenceData {
	private int everyNDays;
	
	public DailyRecurrence(){
		super(RecurrenceType.Daily);
	}

	public int getEveryNDays() {
		return everyNDays;
	}

	public void setEveryNDays(int everyNDays) {
		this.everyNDays = everyNDays;
	}

	@Override
	public String toString() {
		return "DailyRecurrence [everyNDays=" + everyNDays + ", getType()="
				+ getType() + ", isStartNow()=" + isStartNow()
				+ ", getStartAt()=" + getStartAt() + ", isNeverEnd()="
				+ isNeverEnd() + ", getEndAfterNOccurrences()="
				+ getEndAfterNOccurrences() + ", getEndOn()=" + getEndOn()
				+ "]";
	}
	
	
}
