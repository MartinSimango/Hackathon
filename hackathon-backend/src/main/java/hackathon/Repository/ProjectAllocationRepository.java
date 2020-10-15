package hackathon.Repository;

import hackathon.client.request.AboutMeTagsDTO;
import hackathon.client.request.ReceiveDataFromFrontEndDTO;
import hackathon.entity.Employee;
import hackathon.entity.ProjectAllocation;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class ProjectAllocationRepository {

    @Inject
    EntityManager entityManager;

    public void save(long number, String description,String projectCode){
            ProjectAllocation projectAllocation = new ProjectAllocation();
            projectAllocation.setClientInput(description);
            projectAllocation.setTeamSize(number);
            projectAllocation.setProjectCode(projectCode);
            entityManager.merge(projectAllocation);

    }
}
