package com.rean.scheduler.model;

import java.util.Date;

public class RecurrenceData {
	private RecurrenceType type;
	private boolean startNow;
	private Date startAt;
	private boolean neverEnd;
	private int endAfterNOccurrences;
	private Date endOn;

	public RecurrenceData(RecurrenceType type) {
		super();
		this.type = type;
	}

	public RecurrenceData(RecurrenceType type, boolean startNow, Date startAt,
			boolean neverEnd, int endAfterNOccurrences, Date endOn) {
		super();
		this.type = type;
		this.startNow = startNow;
		this.startAt = startAt;
		this.neverEnd = neverEnd;
		this.endAfterNOccurrences = endAfterNOccurrences;
		this.endOn = endOn;
	}

	public RecurrenceType getType() {
		return type;
	}

	public boolean isStartNow() {
		return startNow;
	}

	public Date getStartAt() {
		return startAt;
	}

	public boolean isNeverEnd() {
		return neverEnd;
	}

	public int getEndAfterNOccurrences() {
		return endAfterNOccurrences;
	}

	public Date getEndOn() {
		return endOn;
	}

	protected static class Builder<T> {
		protected final Class<T> builderClass;
		protected RecurrenceType type;
		protected boolean startNow;
		protected Date startAt;
		protected boolean neverEnd;
		protected int endAfterNOccurrences;
		protected Date endOn;

		protected Builder(Class<T> builderClass) {
			this.builderClass = builderClass;
		}

		public T type(RecurrenceType type) {
			this.type = type;
			return builderClass.cast(this);
		}

		public T startNow(boolean startNow) {
			this.startNow = startNow;
			return builderClass.cast(this);
		}

		public T startAt(Date startAt) {
			this.startAt = startAt;
			return builderClass.cast(this);
		}

		public T neverEnd(boolean neverEnd) {
			this.neverEnd = neverEnd;
			return builderClass.cast(this);
		}

		public T endAfterNOccurrences(int endAfterNOccurrences) {
			this.endAfterNOccurrences = endAfterNOccurrences;
			return builderClass.cast(this);
		}

		public T endOn(Date endOn) {
			this.endOn = endOn;
			return builderClass.cast(this);
		}
	}

	public static class RecurrenceBuilder extends Builder<RecurrenceBuilder> {

		protected RecurrenceBuilder() {
			super(RecurrenceBuilder.class);
		}
	}
}
