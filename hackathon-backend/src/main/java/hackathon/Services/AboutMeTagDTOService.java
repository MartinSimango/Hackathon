package hackathon.Services;


import hackathon.Repository.EmployeeRepository;
import hackathon.client.MWLClient;
import hackathon.client.request.AboutMeTagsDTO;
import javax.inject.Singleton;
import javax.inject.Inject;
import java.util.List;


@Singleton
public class AboutMeTagDTOService
{
    @Inject
    private MWLClient mwlClient;

    public List<AboutMeTagsDTO> getAllEmployeeAboutMeTagsDTO()
    {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<AboutMeTagsDTO> list = mwlClient.getAllEmployeeAboutMeTagsDTO();
        employeeRepository.Save(list);

        return list;
    }
}
