package com.rean.scheduler.model;

/**
 * Class represents weekly recurrence data.
 * 
 * @author tahir
 *
 */
public class WeeklyRecurrence extends RecurrenceData {
	private int everyNWeeks;
	private Week repeatOn;

	public WeeklyRecurrence() {
		super(RecurrenceType.Weekly);
	}

	public int getEveryNWeeks() {
		return everyNWeeks;
	}

	public void setEveryNWeeks(int everyNWeeks) {
		this.everyNWeeks = everyNWeeks;
	}

	public Week getRepeatOn() {
		return repeatOn;
	}

	public void setRepeatOn(Week repeatOn) {
		this.repeatOn = repeatOn;
	}

	@Override
	public String toString() {
		return "WeeklyRecurrence [everyNWeeks=" + everyNWeeks + ", repeatOn="
				+ repeatOn + ", getType()=" + getType() + ", isStartNow()="
				+ isStartNow() + ", getStartAt()=" + getStartAt()
				+ ", isNeverEnd()=" + isNeverEnd()
				+ ", getEndAfterNOccurrences()=" + getEndAfterNOccurrences()
				+ ", getEndOn()=" + getEndOn() + "]";
	}

	
}
