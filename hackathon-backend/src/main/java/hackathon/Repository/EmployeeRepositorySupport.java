package hackathon.Repository;

import hackathon.entity.Employee;
import io.micronaut.runtime.ApplicationConfiguration;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Singleton
public class EmployeeRepositorySupport implements EmployeeRepository
{

    @PersistenceContext
    private final EntityManager entityManager;


    public EmployeeRepositorySupport(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Employee save(String name, String aboutMe, List<String> tags){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAboutMe(aboutMe);
        employee.setTags(String.join(",", tags));
        return entityManager.merge(employee);
    }

    @Override
    public List<Employee> getAllEmployees(){
        //todo: Philani write query to return all employees

        return null;
    }

    @Override
    public boolean doesUserExist(String username){
        //todo: Philani write query to determine if user exists
        // entityManager.createNamedQuery()
        return false;

    }

}

