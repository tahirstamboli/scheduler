package com.rean.scheduler.model;

import java.util.Date;

public abstract class RecurrenceData {
	private RecurrenceType type;
	private boolean startNow;
	private Date startAt;
	private boolean neverEnd;
	private int endAfterNOccurrences;
	private Date endOn;

	public RecurrenceData(RecurrenceType type){
		this.type = type;
	}
	
	public RecurrenceType getType() {
		return type;
	}

	public void setType(RecurrenceType type) {
		this.type = type;
	}

	public boolean isStartNow() {
		return startNow;
	}

	public void setStartNow(boolean startNow) {
		this.startNow = startNow;
	}

	public Date getStartAt() {
		return startAt;
	}

	public void setStartAt(Date startAt) {
		this.startAt = startAt;
	}

	public boolean isNeverEnd() {
		return neverEnd;
	}

	public void setNeverEnd(boolean neverEnd) {
		this.neverEnd = neverEnd;
	}

	public int getEndAfterNOccurrences() {
		return endAfterNOccurrences;
	}

	public void setEndAfterNOccurrences(int endAfterNOccurrences) {
		this.endAfterNOccurrences = endAfterNOccurrences;
	}

	public Date getEndOn() {
		return endOn;
	}

	public void setEndOn(Date endOn) {
		this.endOn = endOn;
	}

}
