package hackathon.Repository;

import hackathon.entity.Project;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class ProjectRepository {

    @Inject
    EntityManager entityManager;

    public void save(String description, String projectCode, long teamSize){
        Project project = new Project();
        project.setClientInput(description);
        project.setProjectCode(projectCode);
        project.setTeamSize(teamSize);

        entityManager.merge(project);
    }
}
