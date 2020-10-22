package hackathon.Repository

import hackathon.backend.kotlin.entity.Employee
import javax.inject.Inject
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.NoResultException
import kotlin.math.min

@Singleton
class EmployeeRepository @Inject constructor(private val entityManager: EntityManager) {


     fun save(name: String?, aboutMe: String?, tags: List<String>?): Employee {

        val maxTagsListLength = 20;
        val maxEmployeeAboutMeLength = 500;
        var employeeTags = tags.orEmpty().subList(0, min(maxTagsListLength, tags.orEmpty().size));
        var employeeName = name.orEmpty().substring(0, min(maxEmployeeAboutMeLength, name.orEmpty().length));

        val employee = Employee(name = employeeName,
                aboutMe = aboutMe.orEmpty(),
                tags = java.lang.String.join(",", employeeTags));

        return entityManager.merge(employee);
    }

    fun getAllEmployees(): List<Employee> {
        return entityManager
                .createNamedQuery(Queries.FindAllEmployees.NAME, Employee::class.java)
                .resultList
    }

    fun doesUserExist(name: String): Employee? {
        return try {
                entityManager.createNamedQuery(Queries.FindByName.NAME, Employee::class.java)
                        .setParameter("name", name)
                        .singleResult
            }
            catch (e : NoResultException){
                null
            }
    }

    object Queries {

        object FindByName {
            const val NAME =
                    "Employee.findByEmployeeName"
            const val JPQL =
                    "SELECT e " +
                    "FROM Employee e " +
                    "WHERE e.name = :name"
        }

        object FindAllEmployees {
            const val NAME =
                    "Employee.findAllEmployees"
            const val JPQL =
                    "SELECT e " +
                    "FROM Employee e"
        }
    }
}
