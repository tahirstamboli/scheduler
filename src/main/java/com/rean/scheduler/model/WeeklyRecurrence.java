package com.rean.scheduler.model;

import java.util.Date;
import java.util.List;

/**
 * Class represents weekly recurrence data.
 * 
 * @author tahir
 *
 */
public class WeeklyRecurrence extends RecurrenceData {
	private int everyNWeeks;
	private List<Week> repeatOn;

	public WeeklyRecurrence() {
		super(RecurrenceType.Weekly);
	}

	public WeeklyRecurrence(RecurrenceType type, boolean startNow,
			Date startAt, boolean neverEnd, int endAfterNOccurrences,
			Date endOn, int everyNWeeks, List<Week> repeatOn) {
		super(type, startNow, startAt, neverEnd, endAfterNOccurrences, endOn);
		this.everyNWeeks = everyNWeeks;
		this.repeatOn = repeatOn;
	}

	public static WeeklyRecurrenceBuilder builder() {
		return new WeeklyRecurrenceBuilder();
	}

	public int getEveryNWeeks() {
		return everyNWeeks;
	}

	public List<Week> getRepeatOn() {
		return repeatOn;
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

	/**
	 * 
	 * Builder class
	 *
	 */
	public static class WeeklyRecurrenceBuilder extends
			Builder<WeeklyRecurrenceBuilder> {
		protected int everyNWeeks;
		protected List<Week> repeatOn;

		protected WeeklyRecurrenceBuilder() {
			super(WeeklyRecurrenceBuilder.class);
			this.type = RecurrenceType.Weekly;
		}

		public WeeklyRecurrenceBuilder everyNWeeks(int everyNWeeks) {
			this.everyNWeeks = everyNWeeks;
			return this;
		}

		public WeeklyRecurrenceBuilder repeatOn(List<Week> repeatOn) {
			this.repeatOn = repeatOn;
			return this;
		}

		public WeeklyRecurrence build() {
			return new WeeklyRecurrence(this.type, this.startNow, this.startAt,
					this.neverEnd, this.endAfterNOccurrences, this.endOn,
					this.everyNWeeks, this.repeatOn);
		}
	}

}
