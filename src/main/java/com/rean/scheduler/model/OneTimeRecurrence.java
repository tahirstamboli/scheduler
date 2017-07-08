package com.rean.scheduler.model;

import java.util.Date;

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

	public OneTimeRecurrence(RecurrenceType type, boolean startNow,
			Date startAt, boolean neverEnd, int endAfterNOccurrences, Date endOn) {
		super(type, startNow, startAt, neverEnd, endAfterNOccurrences, endOn);
	}

	public static OneTimeRecurrenceBuilder builder() {
		return new OneTimeRecurrenceBuilder();
	}

	@Override
	public String toString() {
		return "OneTimeRecurrence [getType()=" + getType() + ", isStartNow()="
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
	public static class OneTimeRecurrenceBuilder extends
			Builder<OneTimeRecurrenceBuilder> {

		protected OneTimeRecurrenceBuilder() {
			super(OneTimeRecurrenceBuilder.class);
			this.type = RecurrenceType.Once;
		}

		public OneTimeRecurrence build() {
			return new OneTimeRecurrence(this.type, this.startNow,
					this.startAt, this.neverEnd, this.endAfterNOccurrences,
					this.endOn);
		}

	}

}
