package DataAccess;

import Models.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EmployeesDAO implements IEmployeesDAO {
    private final String employeeFilePath = "employees.json";
    private ArrayList<Employee> _employees;
    public EmployeesDAO() {
        _employees = new ArrayList();
        ReadFromFile();
    }

    public List<Employee> get_employees() {
        return _employees;
    }

    @Override
    public Optional<Employee> GetEmployeeById(UUID employeeId) {
        return this._employees.stream().filter(x -> x.getId() == employeeId).findFirst();
    }

    @Override
    public UUID SaveEmployee(Employee employee) {
        if(null == employee.getId()) {
            employee.setId(UUID.randomUUID());
            this._employees.add(employee);
        }else {
            this._employees.stream().filter(x -> x.getId().equals(employee.getId())).findAny().map(x -> x.updateBy(employee));
        }
        SaveToFile();
        return employee.getId();
    }


    @Override
    public boolean ReadFromFile() {
        ObjectMapper employeesMapper = new ObjectMapper();
        try {
            _employees = employeesMapper.readValue(new File(employeeFilePath), _employees.getClass());
        } catch (IOException e) {
            System.out.println("Error on reading the employees from file.");
            return false;
        }
        return true;
    }

    @Override
    public boolean SaveToFile() {
        ObjectMapper employeesMapper = new ObjectMapper();
        try {
            employeesMapper.writeValue(new File(employeeFilePath), _employees);
        } catch (IOException e) {
            System.out.println("Error on saving employees to file.");
            return false;
        }
        return true;
    }

    @Override
    public void DeleteEmployee(Employee employee) {
        this._employees.removeIf(x -> x.getId() == employee.getId());
        SaveToFile();
    }
}
