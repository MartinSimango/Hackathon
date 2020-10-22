package hackathon.backend.kotlin.controller

import hackathon.Repository.EmployeeRepository
import hackathon.backend.kotlin.client.MWLClient
import hackathon.backend.kotlin.client.request.AboutMeTagsDTO
import hackathon.backend.kotlin.controller.request.ProjectDescriptionDTO
import hackathon.backend.kotlin.controller.response.EmployeeWithSkillsDTO
import hackathon.backend.kotlin.entity.Employee
import hackathon.backend.kotlin.repository.ProjectRepository
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.exceptions.ReadTimeoutException
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.validation.Valid


@Validated
@Controller("/get-employee-with-skills")
class RetrieveEmployeesWithSkillsController @Inject constructor (private val projectRepository: ProjectRepository,
private val employeeRepository: EmployeeRepository, private val mwlClient: MWLClient){
    @Post("/")
    @ExecuteOn(TaskExecutors.IO)
    fun processData(@Body projectDescriptionDTO: @Valid ProjectDescriptionDTO): EmployeeWithSkillsDTO? {
        //save the description to the database
        val description: String = projectDescriptionDTO.description;
        val projectCode: String = projectDescriptionDTO.projectCode
        val teamSize: Long = projectDescriptionDTO.teamSize

        //save project to database
        projectRepository.save(description, projectCode, teamSize)
        println("Saved")

        //todo: Kat and Laaila - ML stuff here
        val employeeList: List<Employee>? = employeeRepository.getAllEmployees()
        // add return type
        return null
    }

    @ExecuteOn(TaskExecutors.IO)
    @Get(value = "/", produces = [MediaType.APPLICATION_JSON])
    fun getData(): List<AboutMeTagsDTO>? {
        return try {
            mwlClient.getAllEmployeeAboutMeTagsDTO()
        } catch (e: ReadTimeoutException) {
            println("TIMEOUT")
            return getData()
        }
    }
}
