package hackathon.backend.kotlin.service

import hackathon.Repository.EmployeeRepository
import hackathon.backend.kotlin.client.MWLClient
import hackathon.backend.kotlin.client.request.AboutMeTagsDTO

import io.netty.handler.timeout.ReadTimeoutException
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional


@Singleton
open class EmployeeService @Inject constructor(private val mwlClient: MWLClient,
private val employeeManager: EmployeeManager){

    open fun saveAllEmployeeAboutMeTagsDTO() {
        try {
            val aboutMeTagsDTOS: List<AboutMeTagsDTO>? = mwlClient.getAllEmployeeAboutMeTagsDTO()
            if (aboutMeTagsDTOS != null) {
                for (aboutMeTagsDTO in aboutMeTagsDTOS) {
                    if (!employeeManager.doesUserExist(aboutMeTagsDTO.name.orEmpty())
                    ) {
                        employeeManager.save(aboutMeTagsDTO.name, aboutMeTagsDTO.aboutMe, aboutMeTagsDTO.tags)
                    }
                }
            }
        } catch (e: ReadTimeoutException) {
            saveAllEmployeeAboutMeTagsDTO() //a timeout occurred try reading from MWL again
        }
    }
}
