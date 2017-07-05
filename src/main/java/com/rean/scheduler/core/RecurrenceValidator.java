package com.rean.scheduler.core;

import org.quartz.SchedulerException;

import com.rean.scheduler.model.HourlyRecurrence;
import com.rean.scheduler.model.OneTimeRecurrence;
import com.rean.scheduler.model.RecurrenceData;
import com.rean.scheduler.model.RecurrenceType;

/**
 * Recurrence data validation utility class.
 * 
 * @author tahir
 *
 */
public class RecurrenceValidator {
	/**
	 * Validate recurrence data by considering <code>RecurrenceType</code>
	 * 
	 * @param recurrenceData
	 * @return
	 * @throws SchedulerException
	 */
	public static boolean validate(RecurrenceData recurrenceData)
			throws SchedulerException {
		boolean valid = true;

		if (recurrenceData == null) {
			throw new SchedulerException(
					"Recurrence data can not be empty or null.");
		} else if (recurrenceData.getType() == null) {
			throw new SchedulerException(
					"Recurrence type of recurrence data can not be empty or null.");
		}

		switch (recurrenceData.getType()) {
		case Once:
			OneTimeRecurrence oneTimeRecurrence = (OneTimeRecurrence) recurrenceData;
			valid = startTimeValidation(oneTimeRecurrence);
			break;
		case Hourly:
			HourlyRecurrence hourlyData = (HourlyRecurrence) recurrenceData;
			valid = validateHourlyRecurrence(hourlyData);
			break;
		case Daily:
			break;
		case Weekly:
			break;
		case Monthly:
			break;
		}

		if (!RecurrenceType.isMember(recurrenceData.getType().name()))
			throw new SchedulerException("Recurrence type "
					+ recurrenceData.getType().name() + " is not valid.");

		return valid;
	}

	/**
	 * Execution start time validation.
	 * 
	 * @param recurrenceData
	 * @return
	 * @throws SchedulerException
	 */
	private static boolean startTimeValidation(RecurrenceData recurrenceData)
			throws SchedulerException {
		if ((!recurrenceData.isStartNow() && recurrenceData.getStartAt() == null)
				|| (recurrenceData.isStartNow() && recurrenceData.getStartAt() != null))
			throw new SchedulerException(
					"Please provide either \"Start Now\" or \"Start At\" option for valid Recurrence.");
		return true;
	}

	/**
	 * Execution end time validation.
	 * 
	 * @param recurrenceData
	 * @return
	 * @throws SchedulerException
	 */
	private static boolean endTimeValidation(RecurrenceData recurrenceData)
			throws SchedulerException {
		if ((!recurrenceData.isNeverEnd() && recurrenceData.getEndOn() == null && recurrenceData
				.getEndAfterNOccurrences() == 0)
				|| (recurrenceData.isNeverEnd() && recurrenceData.getEndOn() != null)
				|| (recurrenceData.getEndOn() != null && recurrenceData
						.getEndAfterNOccurrences() > 0)
				|| (recurrenceData.isNeverEnd() && recurrenceData
						.getEndAfterNOccurrences() > 0))
			throw new SchedulerException(
					"Please provide either \"Never End\", \"End On\" or \"End After N Occurrences\" option for valid Recurrence.");
		return true;
	}

	/**
	 * Validate hourly recurrence.
	 * 
	 * @param recurrenceData
	 * @return
	 * @throws SchedulerException
	 */
	private static boolean validateHourlyRecurrence(
			HourlyRecurrence recurrenceData) throws SchedulerException {
		boolean valid = true;
		valid = startTimeValidation(recurrenceData);
		if (recurrenceData.getEveryNHrs() == 0)
			throw new SchedulerException(
					"Please provide valid value for Every N Hours option for hourly recurrence.");
		valid = endTimeValidation(recurrenceData);
		return valid;
	}
}
