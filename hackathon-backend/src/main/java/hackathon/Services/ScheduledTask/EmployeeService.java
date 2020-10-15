package hackathon.Services.ScheduledTask;

import hackathon.Repository.EmployeeRepository;
import hackathon.client.MWLClient;
import hackathon.client.request.AboutMeTagsDTO;
import hackathon.entity.Employee;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class EmployeeService {

    @Inject
    private MWLClient mwlClient;

    public void saveAllEmployeeAboutMeTagsDTO()
    {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<AboutMeTagsDTO> aboutMeTagsDTOS = mwlClient.getAllEmployeeAboutMeTagsDTO();
        for(AboutMeTagsDTO aboutMeTagsDTO: aboutMeTagsDTOS){
            if(!employeeRepository.doesUserExist(aboutMeTagsDTO.getName())) {
                employeeRepository.save(aboutMeTagsDTO.getName(), aboutMeTagsDTO.getAboutMe(), aboutMeTagsDTO.getTags());
            }
        }
    }


}
