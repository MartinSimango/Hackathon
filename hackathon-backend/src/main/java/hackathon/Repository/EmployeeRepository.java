package hackathon.Repository;

import hackathon.entity.Employee;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import java.util.List;

@Singleton
public class EmployeeRepository
{

    @Inject
    EntityManager entityManager;

    public Employee save (String name, String aboutMe, List<String> tags){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAboutMe(aboutMe);
        employee.setTags(String.join(",", tags));
        return entityManager.merge(employee);
    }

    public List<Employee> getAllEmployees(){
        //todo: Philani write query to return all employees

        return null;
    }

    public boolean doesUserExist(String username){
        //todo: Philani write query to determine if user exists
       // entityManager.createNamedQuery()
        return false;

    }

}
