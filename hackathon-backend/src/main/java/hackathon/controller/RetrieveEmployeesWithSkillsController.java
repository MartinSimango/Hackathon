package hackathon.controller;


import hackathon.Repository.EmployeeRepository;
import hackathon.Repository.ProjectRepository;
import hackathon.controller.request.ProjectDescriptionDTO;
import hackathon.controller.response.EmployeesWithSkillsDTO;
import hackathon.entity.Employee;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.validation.Validated;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@Validated
@Controller("/get-employee-with-skills")
public class RetrieveEmployeesWithSkillsController {

    @Inject
    ProjectRepository projectRepository;

    @Inject
    EmployeeRepository employeeRepository;

    @Post("/")
    @ExecuteOn(TaskExecutors.IO)
    public EmployeesWithSkillsDTO processData(@Body @Valid ProjectDescriptionDTO projectDescriptionDTO) {
        //save the description to the database
        String description = projectDescriptionDTO.getDescription();
        String projectCode = projectDescriptionDTO.getProjectCode();
        Long teamSize = projectDescriptionDTO.getTeamSize();

        //save project to database
        projectRepository.save(description, projectCode, teamSize);

        System.out.println("Saved");
        //todo: Kat and Laaila - ML stuff here
        List<Employee> employeeList = employeeRepository.getAllEmployees();
        // add return type
        return null;

    }


}
