package DataAccess;

import Models.Employee;

import java.util.Optional;
import java.util.UUID;

public interface IEmployeesDAO {
    public Optional<Employee> GetEmployeeById(UUID employeeId);
    public UUID SaveEmployee(Employee employee);
    public boolean ReadFromFile();
    public boolean SaveToFile();
    public void DeleteEmployee(Employee employee);
}
