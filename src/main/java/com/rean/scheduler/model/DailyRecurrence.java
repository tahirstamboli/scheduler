package com.rean.scheduler.model;

import java.util.Date;

/**
 * Class represents daily recurrence data.
 * 
 * @author tahir
 *
 */
public class DailyRecurrence extends RecurrenceData {
	private int everyNDays;

	public DailyRecurrence() {
		super(RecurrenceType.Daily);
	}

	public DailyRecurrence(RecurrenceType type, boolean startNow, Date startAt,
			boolean neverEnd, int endAfterNOccurrences, Date endOn,
			int everyNDays) {
		super(type, startNow, startAt, neverEnd, endAfterNOccurrences, endOn);
		this.everyNDays = everyNDays;
	}

	public static DailyRecurrenceBuilder builder() {
		return new DailyRecurrenceBuilder();
	}

	public int getEveryNDays() {
		return everyNDays;
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

	/**
	 * 
	 * Builder class
	 *
	 */
	public static class DailyRecurrenceBuilder extends
			Builder<DailyRecurrenceBuilder> {
		protected int everyNDays;

		protected DailyRecurrenceBuilder() {
			super(DailyRecurrenceBuilder.class);
			this.type = RecurrenceType.Daily;
		}

		public DailyRecurrenceBuilder everyNDays(int everyNDays) {
			this.everyNDays = everyNDays;
			return this;

		}

		public DailyRecurrence build() {
			return new DailyRecurrence(this.type, this.startNow, this.startAt,
					this.neverEnd, this.endAfterNOccurrences, this.endOn,
					this.everyNDays);
		}

	}

}
