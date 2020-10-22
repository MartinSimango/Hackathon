package hackathon.backend.kotlin.entity

import javax.persistence.*

@Entity
@Table(name = "project_allocation")
data class ProjectAllocation (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    @ManyToOne
    @JoinColumn(name = "project_id")
    var project: Project,

    @ManyToOne
    @JoinColumn(name = "employee_id")
    var employee: Employee
)
