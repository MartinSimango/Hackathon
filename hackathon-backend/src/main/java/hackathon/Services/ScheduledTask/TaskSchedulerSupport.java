package hackathon.Services.ScheduledTask;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class TaskSchedulerSupport implements TaskScheduler {
    private static final Logger LOG = LoggerFactory.getLogger(TaskScheduler.class);
    @Inject
    EmployeeService employeeService;

    //run every day
    @Scheduled(fixedDelay = "86400s", initialDelay = "0s")
    @ExecuteOn(TaskExecutors.IO)
    public void scheduledTasks() {
        LOG.info("Running task to fetch MWL employee tags and about me's");
        employeeService.saveAllEmployeeAboutMeTagsDTO();
        LOG.info("Task finished!");

    }
}
