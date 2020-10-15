package hackathon.Repository;

import hackathon.Services.AboutMeTagDTOService;
import hackathon.client.request.AboutMeTagsDTO;
import hackathon.entity.Employee;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import java.util.List;

@Singleton
public class EmployeeRepository
{

    @Inject
    EntityManager entityManager;

    public void Save (List<AboutMeTagsDTO> thingsToSav){

        for (AboutMeTagsDTO item : thingsToSav) {
            Employee employee = new Employee();
            employee.setAboutMe(item.getAboutMe());
            employee.setName(item.getName());
            employee.setTags(String.join(";", employee.getTags()));
            entityManager.merge(employee);
        }
    }


}
