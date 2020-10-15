package hackathon.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project_allocation")
public class ProjectAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;


    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getClientInput() {
        return clientInput;
    }

    public void setClientInput(String clientInput) {
        this.clientInput = clientInput;
    }

    public Long getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(Long teamSize) {
        this.teamSize = teamSize;
    }

    //todo: Martin review lazy fetch type
    @OneToMany (mappedBy ="projectAllocation", fetch = FetchType.LAZY)
    private List<Employee> employee = new ArrayList<>();

    @NotNull
    @Column(name = "project_code", nullable = false)
    private String projectCode;

    @NotNull
    @Column(name = "client_input", nullable = false)
    private String clientInput;

    @NotNull
    @Column(name = "team_size", nullable = false)
    private Long teamSize;



}
