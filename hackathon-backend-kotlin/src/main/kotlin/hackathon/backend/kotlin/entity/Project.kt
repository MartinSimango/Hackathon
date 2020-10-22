package hackathon.backend.kotlin.entity

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "project")
data class Project (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    @NotNull
    @Column(name = "project_code", nullable = false)
    var projectCode :String,

    @NotNull
    @Column(name = "client_input", nullable = false)
    var clientInput:  String,

    @NotNull
    @Column(name = "team_size", nullable = false)
    var teamSize:  Long
)
