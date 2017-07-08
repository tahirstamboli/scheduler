package com.rean.scheduler.model;

import java.util.Date;

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

	public HourlyRecurrence(RecurrenceType type, boolean startNow,
			Date startAt, boolean neverEnd, int endAfterNOccurrences,
			Date endOn, int everyNHrs) {
		super(type, startNow, startAt, neverEnd, endAfterNOccurrences, endOn);
		this.everyNHrs = everyNHrs;
	}

	public static HourlyRecurrenceBuilder builder() {
		return new HourlyRecurrenceBuilder();
	}

	public int getEveryNHrs() {
		return everyNHrs;
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

	/**
	 * 
	 * Builder class
	 *
	 */
	public static class HourlyRecurrenceBuilder extends
			Builder<HourlyRecurrenceBuilder> {
		protected int everyNHrs;

		protected HourlyRecurrenceBuilder() {
			super(HourlyRecurrenceBuilder.class);
			this.type = RecurrenceType.Hourly;
		}

		public HourlyRecurrenceBuilder everyNHrs(int everyNHrs) {
			this.everyNHrs = everyNHrs;
			return this;
		}

		public HourlyRecurrence build() {
			return new HourlyRecurrence(this.type, this.startNow, this.startAt,
					this.neverEnd, this.endAfterNOccurrences, this.endOn,
					this.everyNHrs);
		}

	}

}
