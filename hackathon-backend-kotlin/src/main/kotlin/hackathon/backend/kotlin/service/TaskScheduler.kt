package hackathon.backend.kotlin.service

import io.micronaut.scheduling.annotation.Scheduled
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskScheduler @Inject constructor(private val employeeService: EmployeeService) {


    //run every day
    @Scheduled(fixedDelay = "86400s", initialDelay = "0s")
    fun scheduledTasks() {
        LOG.info("Running task to fetch MWL employee tags and about me's")
     //   employeeService.saveAllEmployeeAboutMeTagsDTO()
        LOG.info("Task finished!")
    }

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(TaskScheduler::class.java)
    }
}
