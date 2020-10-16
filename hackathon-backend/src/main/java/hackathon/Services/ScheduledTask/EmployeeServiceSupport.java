package hackathon.Services.ScheduledTask;


import hackathon.Repository.EmployeeRepository;
import hackathon.client.MWLClient;
import hackathon.client.request.AboutMeTagsDTO;
import io.netty.handler.timeout.ReadTimeoutException;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class EmployeeServiceSupport implements EmployeeService {

    @Inject
    private MWLClient mwlClient;

    @Inject
    private EmployeeRepository employeeRepository;

    @Override
    public void saveAllEmployeeAboutMeTagsDTO()
    {
        try {
            List<AboutMeTagsDTO> aboutMeTagsDTOS = mwlClient.getAllEmployeeAboutMeTagsDTO();
            for (AboutMeTagsDTO aboutMeTagsDTO : aboutMeTagsDTOS) {
                if (!employeeRepository.doesUserExist(aboutMeTagsDTO.getName())) {
                    employeeRepository.save(aboutMeTagsDTO.getName(), aboutMeTagsDTO.getAboutMe(), aboutMeTagsDTO.getTags());
                }
            }
        }
        catch (ReadTimeoutException e){
            saveAllEmployeeAboutMeTagsDTO(); //a timeout occurred try reading from MWL again
        }
    }


}
