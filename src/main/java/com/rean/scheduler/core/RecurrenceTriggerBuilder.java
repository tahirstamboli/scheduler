package com.rean.scheduler.core;

import java.util.Date;

import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import com.rean.scheduler.model.DailyRecurrence;
import com.rean.scheduler.model.HourlyRecurrence;
import com.rean.scheduler.model.OneTimeRecurrence;
import com.rean.scheduler.model.RecurrenceData;
import com.rean.scheduler.model.RecurrenceType;

/**
 * Class builds instance of {@link org.quartz.Trigger} based on the
 * {@link RecurrenceType}
 * 
 * @author tahir
 *
 */
public class RecurrenceTriggerBuilder {
	private Trigger trigger;
	private RecurrenceData data;

	/**
	 * Get instance of <code>RecurrenceTriggerBuilder</code>
	 * 
	 * @return
	 */
	public static RecurrenceTriggerBuilder newTrigger() {
		return new RecurrenceTriggerBuilder();
	}

	/**
	 * Get instance of <code>OneTimeTriggerBuilder</code>
	 * 
	 * @return
	 */
	public static OneTimeTriggerBuilder oneTimeTrigger() {
		return OneTimeTriggerBuilder.newTrigger();
	}

	/**
	 * Get instance of <code>HourlyTriggerBuilder</code>
	 * 
	 * @return
	 */
	public static HourlyTriggerBuilder hourlyTrigger() {
		return HourlyTriggerBuilder.newTrigger();
	}

	/**
	 * Get instance of <code>DailyTriggerBuilder</code>
	 * 
	 * @return
	 */
	public static DailyTriggerBuilder dailyTrigger() {
		return DailyTriggerBuilder.newTrigger();
	}

	/**
	 * Register <code>RecurrenceData</code> to
	 * <code>RecurrenceTriggerBuilder</code>
	 * 
	 * @param data
	 * @return
	 */
	public RecurrenceTriggerBuilder withRecurrence(RecurrenceData data) {
		this.data = data;
		return this;
	}

	/**
	 * Build an instance of <code>Trigger</code> which is fired against
	 * schedulable job
	 * 
	 * @return
	 * @throws SchedulerException
	 */
	public Trigger build() throws SchedulerException {
		if (data == null) {
			throw new SchedulerException(
					"Recurrence data can not be null or empty.");
		} else if (data.getType() == null) {
			throw new SchedulerException(
					"Recurrence type can not be null or empty.");
		}

		switch (data.getType()) {

		case Once:
			OneTimeRecurrence onceData = (OneTimeRecurrence) data;
			trigger = onceData.isStartNow() ? OneTimeTriggerBuilder
					.newTrigger().startNow().build() : OneTimeTriggerBuilder
					.newTrigger().startAt(onceData.getStartAt()).build();
			break;

		case Hourly:
			HourlyRecurrence hourlyData = (HourlyRecurrence) data;
			HourlyTriggerBuilder hourlyTriggerBuilder = HourlyTriggerBuilder
					.newTrigger();
			hourlyTriggerBuilder = hourlyData.isStartNow() ? hourlyTriggerBuilder
					.startNow() : hourlyTriggerBuilder.startAt(hourlyData
					.getStartAt());
			if (hourlyData.isNeverEnd())
				hourlyTriggerBuilder = hourlyTriggerBuilder.neverEnd();
			else if (hourlyData.getEndOn() != null)
				hourlyTriggerBuilder = hourlyTriggerBuilder.endOn(hourlyData
						.getEndOn());
			else
				hourlyTriggerBuilder = hourlyTriggerBuilder
						.endAfterNOccurrences(hourlyData
								.getEndAfterNOccurrences());
			hourlyTriggerBuilder = hourlyTriggerBuilder.everyNHour(hourlyData
					.getEveryNHrs());
			trigger = hourlyTriggerBuilder.build();
			break;

		case Daily:
			DailyRecurrence dailyData = (DailyRecurrence) data;
			DailyTriggerBuilder dailyTriggerBuilder = DailyTriggerBuilder
					.newTrigger();
			dailyTriggerBuilder = dailyData.isStartNow() ? dailyTriggerBuilder
					.startNow() : dailyTriggerBuilder.startAt(dailyData
					.getStartAt());
			if (dailyData.isNeverEnd())
				dailyTriggerBuilder = dailyTriggerBuilder.neverEnd();
			else if (dailyData.getEndOn() != null)
				dailyTriggerBuilder = dailyTriggerBuilder.endOn(dailyData
						.getEndOn());
			else
				dailyTriggerBuilder = dailyTriggerBuilder
						.endAfterNOccurrences(dailyData
								.getEndAfterNOccurrences());

			dailyTriggerBuilder = dailyTriggerBuilder.everyNDayz(dailyData
					.getEveryNDays());

			trigger = dailyTriggerBuilder.build();
			break;

		case Weekly:
			break;

		case Monthly:
			break;
		}
		return trigger;
	}

}

/**
 * One Time Trigger builder.
 */

class OneTimeTriggerBuilder {
	private boolean startNow = false;
	private Date startAt;

	public static OneTimeTriggerBuilder newTrigger() {
		return new OneTimeTriggerBuilder();
	}

	public OneTimeTriggerBuilder startNow() {
		this.startNow = true;
		return this;
	}

	public OneTimeTriggerBuilder startAt(Date at) {
		this.startAt = at;
		return this;
	}

	public Trigger build() {
		Trigger trigger = null;
		if (startNow) {
			trigger = TriggerBuilder.newTrigger()
					// .withIdentity("trigger1", "group1")
					.withSchedule(
							SimpleScheduleBuilder.simpleSchedule()
									.withRepeatCount(0)).startNow().build();
		} else {
			trigger = TriggerBuilder
					.newTrigger()
					.withSchedule(
							SimpleScheduleBuilder.simpleSchedule()
									.withRepeatCount(0)).startAt(startAt)
					.build();
		}
		return trigger;
	}

}

/**
 * Hourly Trigger builder.
 */

class HourlyTriggerBuilder {
	@SuppressWarnings("rawtypes")
	TriggerBuilder hourlyTriggerBuilder;
	SimpleScheduleBuilder scheduleBuilder;

	private HourlyTriggerBuilder() {
		hourlyTriggerBuilder = TriggerBuilder.newTrigger();
		scheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
	}

	public static HourlyTriggerBuilder newTrigger() {
		return new HourlyTriggerBuilder();
	}

	public HourlyTriggerBuilder startNow() {
		hourlyTriggerBuilder.startNow();
		return this;
	}

	public HourlyTriggerBuilder startAt(Date at) {
		hourlyTriggerBuilder.startAt(at);
		return this;
	}

	public HourlyTriggerBuilder endOn(Date endOn) {
		hourlyTriggerBuilder.endAt(endOn);
		return this;
	}

	public HourlyTriggerBuilder neverEnd() {
		scheduleBuilder.repeatForever();
		return this;
	}

	public HourlyTriggerBuilder endAfterNOccurrences(int occurrences) {
		scheduleBuilder.withRepeatCount(occurrences - 1);
		return this;
	}

	public HourlyTriggerBuilder everyNHour(int hrs) {
		scheduleBuilder.withIntervalInHours(hrs);
		return this;
	}

	@SuppressWarnings("unchecked")
	public Trigger build() {
		return hourlyTriggerBuilder.withSchedule(scheduleBuilder).build();
	}
}

/**
 * Daily Trigger builder.
 */

class DailyTriggerBuilder {

	@SuppressWarnings("rawtypes")
	TriggerBuilder dailyTriggerBuilder;
	SimpleScheduleBuilder scheduleBuilder;

	private DailyTriggerBuilder() {
		dailyTriggerBuilder = TriggerBuilder.newTrigger();
		scheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
	}

	public static DailyTriggerBuilder newTrigger() {
		return new DailyTriggerBuilder();
	}

	public DailyTriggerBuilder startNow() {
		dailyTriggerBuilder.startNow();
		return this;
	}

	public DailyTriggerBuilder startAt(Date at) {
		dailyTriggerBuilder.startAt(at);
		return this;
	}

	public DailyTriggerBuilder endOn(Date endOn) {
		dailyTriggerBuilder.endAt(endOn);
		return this;
	}

	public DailyTriggerBuilder neverEnd() {
		scheduleBuilder.repeatForever();
		return this;
	}

	public DailyTriggerBuilder endAfterNOccurrences(int occurrences) {
		scheduleBuilder.withRepeatCount(occurrences - 1);
		return this;
	}

	public DailyTriggerBuilder everyNDayz(int dayz) {
		scheduleBuilder.withIntervalInHours(dayz * 24);
		return this;
	}

	@SuppressWarnings("unchecked")
	public Trigger build() {
		return dailyTriggerBuilder.withSchedule(scheduleBuilder).build();
	}

}