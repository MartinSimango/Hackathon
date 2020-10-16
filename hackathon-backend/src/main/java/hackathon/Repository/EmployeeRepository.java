package hackathon.Repository;

import hackathon.entity.Employee;

import java.util.List;

public interface EmployeeRepository
{

    Employee save(String name, String aboutMe, List<String> tags);

    List<Employee> getAllEmployees();

    boolean doesUserExist(String username);

}
