package hackathon.Repository;

public interface ProjectRepository {

    void save(String description, String projectCode, long teamSize);

}
