package hackathon.backend.kotlin.controller

import hackathon.Repository.EmployeeRepository
import hackathon.backend.kotlin.client.MWLClient
import hackathon.backend.kotlin.client.request.AboutMeTagsDTO
import hackathon.backend.kotlin.controller.request.ProjectDescriptionDTO
import hackathon.backend.kotlin.controller.response.EmployeeWithSkillsDTO
import hackathon.backend.kotlin.entity.Employee
import hackathon.backend.kotlin.repository.ProjectRepository
import hackathon.backend.kotlin.service.Element
import hackathon.backend.kotlin.service.EmployeeMatch
import hackathon.backend.kotlin.service.SkillOutput
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.exceptions.ReadTimeoutException
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import io.micronaut.validation.Validated
import java.util.*
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


        val employeeList: MutableList<Employee> = ArrayList<Employee>()
        val Lailaa = Employee(name = "Lailaa", aboutMe = "", tags = java.lang.String.join(",", Arrays.asList("data science", "machine Learning", "power bi", "sql")))
        employeeList.add(Lailaa)
        val Kat = Employee(name = "Kat", aboutMe = "", tags = java.lang.String.join(",", Arrays.asList("software development", "machine Learning", "computer science")))
        employeeList.add(Kat)
        val Ian = Employee(name = "Ian", aboutMe = "", tags = java.lang.String.join(",", Arrays.asList("developer", "machine Learning", "software development")))
        employeeList.add(Ian)
        val Martin = Employee(name = "Martin", aboutMe = "", tags = java.lang.String.join(",", Arrays.asList("software development", "java", "sql", ".net")))
        employeeList.add(Martin)
        val Shannon = Employee(name = "Shannon", aboutMe = "", tags = java.lang.String.join(",", Arrays.asList("data science", "machine Learning", "power bi", "business intelligence", "consulting")))
        employeeList.add(Shannon)
        val Nicole = Employee(name = "Nicole", aboutMe = "", tags = java.lang.String.join(",", Arrays.asList("data science", "machine Learning", "azure", "ssis", "data engineer")))
        employeeList.add(Nicole)
        val Greg = Employee(name = "Greg", aboutMe = "", tags = java.lang.String.join(",", Arrays.asList("data science", "machine Learning", "analytics", "business analytics", "business intelligence")))
        employeeList.add(Greg)
        val Matt = Employee(name = "Matt", aboutMe = "", tags = java.lang.String.join(",", Arrays.asList("data science", "machine Learning", "database", "etl")))
        employeeList.add(Matt)
        val Philani = Employee(name = "Philani", aboutMe = "", tags = java.lang.String.join(",", Arrays.asList("business consulting", "agile", "power bi")))
        employeeList.add(Philani)
        val Jay = Employee(name = "Jay", aboutMe = "", tags = java.lang.String.join(",", Arrays.asList("scrum", "data science", "machine Learning", "ssis")))
        employeeList.add(Jay)


        //val employeeList: List<Employee> = employeeRepository.getAllEmployees()


        // Store skills count of each employee
        val employee_skills_count: MutableList<Double> = ArrayList(employeeList.size)
        val elements: MutableList<Element> = ArrayList()
        val skill_output_arr: ArrayList<SkillOutput> = ArrayList<SkillOutput>()

        //TODO - Kats input
        val kw_description: MutableList<String> = ArrayList()
        kw_description.add("consulting")
        kw_description.add("power bi")
        kw_description.add("ssis")
        kw_description.add("data science")
        kw_description.add("aws")


        val denominator = kw_description.size.toDouble()
        val match_matrix = Array(employeeList.size) { IntArray(kw_description.size) }
        val names_output: MutableList<String> = ArrayList()
        val unmatched_output: MutableList<String> = ArrayList()
        val min_team_size = 5
        val employee_match_arr: ArrayList<EmployeeMatch> = ArrayList<EmployeeMatch>()
        for (i in employeeList.indices) {
            // go through all employees
            val temp = employeeList[i]
            var count_matching_skills = 0
            System.out.println("__" + temp.name)
            for (j in kw_description.indices) {
                // go through description
                val curr_description = kw_description[j].replace("\\s+".toRegex(), "").toLowerCase()
                println("desc$curr_description")
                val employee_tags = temp.tags.split(",")

                for (k in 0 until employee_tags.size) {
                    // go through employee skills
                    val curr_skill: String = employee_tags[k].replace("\\s+".toRegex(), "").toLowerCase()
                    println("skill$curr_skill")
                    if (curr_description == curr_skill) {
                        println("true$curr_description$curr_skill")
                        println("____________")
                        println(i)
                        println(j)
                        match_matrix[i][j] = 1
                        count_matching_skills++
                    }
                }
            }
            employee_skills_count.add(count_matching_skills.toDouble() / denominator * 100)
            elements.add(Element(i, count_matching_skills))
            employee_match_arr.add(EmployeeMatch(temp.name, count_matching_skills.toDouble() / denominator * 100))
        }
        for (l in employee_skills_count.indices) {
            println(employeeList[l].name.toString() + " " + employee_skills_count[l])
            println(employeeList[l].name.toString() + " " + elements[l]!!.value)
        }
        for (ii in employeeList.indices) {
            for (jj in kw_description.indices) {
                print(match_matrix[ii][jj].toString() + " ")
            }
            println()
        }
        elements.sort()
        elements.reverse() // If you want reverse order
        for (element in elements) {
            println(element!!.value.toString() + " " + element.index + " " + employeeList[element.index].name
                    + " " + employee_match_arr[element.index].employee_skills_percentage)
        }


        // Go through matrix
        for (j in kw_description.indices) {
            println("DESC" + kw_description[j])
            var skill_matched = false
            val employee_skill_arr: ArrayList<EmployeeMatch> = ArrayList<EmployeeMatch>()
            val temp_output = SkillOutput(kw_description[j], employee_skill_arr)
            for (i in employeeList.indices) {
                println("employee" + employeeList[elements[i]!!.index].name)
                if (names_output.size < min_team_size) {
                    if (match_matrix[elements[i]!!.index][j] == 1) {
                        skill_matched = true
                        temp_output.employee_skill_arr.add(employee_match_arr[elements[i]!!.index])
                        println(employee_match_arr[elements[i]!!.index])
                        if (!names_output.contains(employeeList[elements[i]!!.index].name)) {
                            names_output.add(employeeList[elements[i]!!.index].name)
                            println(employeeList[elements[i]!!.index].name)
                        }
                        break
                    }
                }
            }
            if (skill_matched == false) {
                unmatched_output.add("Skill '" + kw_description[j] + "' not matched at BSG.")
            }
            skill_output_arr.add(temp_output)
        }
        while (names_output.size < min_team_size) {
            for (ind in employeeList.indices) {
                if (!names_output.contains(employeeList[elements[ind]!!.index].name) && elements[ind]!!.value != 0) {
                    names_output.add(employeeList[elements[ind]!!.index].name)
                    for (j in kw_description.indices) {
                        if (match_matrix[elements[ind]!!.index][j] == 1) {
                            skill_output_arr[j].employee_skill_arr.add(employee_match_arr[elements[ind]!!.index])
                        }
                    }
                    break
                }
            }
        }
        for (n in names_output.indices) {
            println(names_output[n])
        }
        names_output.addAll(unmatched_output)
        println("Selected Team: "
                + names_output)
        for (n in kw_description.indices) {
            println()
            println("Required Skill: " + skill_output_arr[n].skill_description)
            if (skill_output_arr[n].employee_skill_arr.size === 0) {
                println("Selected Employee: " + "No Match Found")
            }
            for (m in 0 until skill_output_arr[n].employee_skill_arr.size) {
                println("Selected Employee: " + skill_output_arr[n].employee_skill_arr[m].employee_name)
                println("Selected Employee Overall Match: " + skill_output_arr[n].employee_skill_arr[m].employee_skills_percentage.toString() + "%")
            }
        }



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
