package com.rean.scheduler.model;

import java.util.Date;

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

	public MonthlyRecurrence(RecurrenceType type, boolean startNow,
			Date startAt, boolean neverEnd, int endAfterNOccurrences,
			Date endOn, int everyNMonths) {
		super(type, startNow, startAt, neverEnd, endAfterNOccurrences, endOn);
		this.everyNMonths = everyNMonths;
	}

	public static MonthlyRecurrenceBuiler builder() {
		return new MonthlyRecurrenceBuiler();
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

	/**
	 * 
	 * Builder class
	 *
	 */
	public static class MonthlyRecurrenceBuiler extends
			Builder<MonthlyRecurrenceBuiler> {
		protected int everyNMonths;

		protected MonthlyRecurrenceBuiler() {
			super(MonthlyRecurrenceBuiler.class);
			this.type = RecurrenceType.Monthly;
		}

		public MonthlyRecurrenceBuiler everyNMonths(int everyNMonths) {
			this.everyNMonths = everyNMonths;
			return this;
		}

		public MonthlyRecurrence build() {
			return new MonthlyRecurrence(this.type, this.startNow,
					this.startAt, this.neverEnd, this.endAfterNOccurrences,
					this.endOn, this.everyNMonths);
		}
	}

}
