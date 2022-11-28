package bit.bakdaulet.java.backend.services;

import bit.bakdaulet.java.backend.models.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private static final HashMap<String,EmployeeModel> employees = new HashMap<>();

    static{
        EmployeeModel employeeModel1 = new EmployeeModel(UUID.randomUUID().toString(),"Bakdaulet","Ablayev",
                "ablayev.bakdaulet@mail.ru","Bbakenzi","Developers","Java backend developer",500000);
        EmployeeModel employeeModel2 = new EmployeeModel(UUID.randomUUID().toString(),"Ivan","Ivanov",
                "ivanov@mail.ru","Bbakenzi","Management","SMM manager",450000);
        EmployeeModel employeeModel3 = new EmployeeModel(UUID.randomUUID().toString(),"Maksim","Maksimov",
                "maksimov@mail.ru","Bbakenzi","Administrative","administrator",150000);
        EmployeeModel employeeModel4 = new EmployeeModel(UUID.randomUUID().toString(),"Ilyas","Zhuanyshev",
                "ilyas@mail.ru","Bitlab","Developers","Senior developer",1500000);

        employees.put(employeeModel1.getEmployeeId(),employeeModel1);
        employees.put(employeeModel2.getEmployeeId(),employeeModel2);
        employees.put(employeeModel3.getEmployeeId(),employeeModel3);
        employees.put(employeeModel4.getEmployeeId(),employeeModel4);
    }

    @Override
    public void createEmployee(EmployeeModel employeeModel) {
        employeeModel.setEmployeeId(UUID.randomUUID().toString());
        employees.put(employeeModel.getEmployeeId(),employeeModel);
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public EmployeeModel getEmployeeById(String employeeId) {
        return employees.get(employeeId);
    }

    @Override
    public void updateEmployeeById(String employeeId, EmployeeModel employeeModel) {
        employeeModel.setEmployeeId(employeeId);
        employees.put(employeeId,employeeModel);
    }

    @Override
    public void deleteEmployeeById(String employeeId) {
        employees.remove(employeeId);
    }
}
