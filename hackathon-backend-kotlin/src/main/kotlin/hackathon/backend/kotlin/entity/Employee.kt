package hackathon.backend.kotlin.entity

import hackathon.Repository.EmployeeRepository
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "employee")
@NamedQueries( NamedQuery(name = EmployeeRepository.Queries.FindAllEmployees.NAME,
query = EmployeeRepository.Queries.FindAllEmployees.JPQL),
NamedQuery(name = EmployeeRepository.Queries.FindByName.NAME,
query = EmployeeRepository.Queries.FindByName.JPQL))
data class Employee (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    @NotNull
    @Column(name = "name", nullable = false)
    var name: String,

    @NotNull
    @Column(name = "about_me", nullable = false)
    var aboutMe: String,

    @NotNull
    @Column(name = "tags", nullable = true)
    var tags: String
)
