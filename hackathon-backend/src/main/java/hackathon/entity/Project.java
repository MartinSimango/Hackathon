package hackathon.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

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
