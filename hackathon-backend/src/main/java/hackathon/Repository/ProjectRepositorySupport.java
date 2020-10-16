package hackathon.Repository;

import hackathon.entity.Project;
import io.micronaut.data.annotation.Repository;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

@Singleton
public class ProjectRepositorySupport implements ProjectRepository {

    @Inject
    private EntityManager entityManager;

    public void save(String description, String projectCode, long teamSize){
        Project project = new Project();
        project.setClientInput(description);
        project.setProjectCode(projectCode);
        project.setTeamSize(teamSize);

        entityManager.merge(project);

    }
}
