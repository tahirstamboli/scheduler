## Scheduler

Wrapper over quartz library, Quartz is a richly featured, open source job scheduling library that can be integrated within virtually any Java application - from the smallest stand-alone application to the largest e-commerce system. Quartz can be used to create simple or complex schedules for executing tens, hundreds, or even tens-of-thousands of jobs; jobs whose tasks are defined as standard Java components that may execute virtually anything you may program them to do.

#### How to schedule task ?

Example : Schedule task now for one time
```
HelloWorldJob job = new HelloWorldJob();         // implements Schedulable
OneTimeRecurrence data = OneTimeRecurrence.builder().startNow(true).build();// Different recurrence pattern created like OneTime, Hourly, Daily, Weekly, Monthly etc.
Scheduler scheduler = SchedulerFactory.getScheduler(); // Handle to the Quartz Scheduler
scheduler.start();
scheduler.schedule(job, data);                  // Schedule job with provided recurrence data
```
