package bit.bakdaulet.java.backend.services;

import bit.bakdaulet.java.backend.models.EmployeeModel;

import java.util.List;

public interface EmployeeService {

    void createEmployee(EmployeeModel employeeModel);
    List<EmployeeModel> getAllEmployees();
    EmployeeModel getEmployeeById(String employeeId);
    void updateEmployeeById(String employeeId,EmployeeModel employeeModel);
    void deleteEmployeeById(String employeeId);

}
