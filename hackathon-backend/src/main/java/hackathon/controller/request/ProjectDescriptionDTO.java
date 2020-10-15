package hackathon.controller.request;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class ProjectDescriptionDTO {

    private String description;
    private String projectCode;
    private long teamSize;


    public ProjectDescriptionDTO(String description, String projectCode, long teamSize){
        this.description = description;
        this.projectCode = projectCode;
        this.teamSize = teamSize;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(long teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    public String toString() {
        return "ProjectDescriptionDTO{" +
                "description='" + description + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", teamSize=" + teamSize +
                '}';
    }

}
