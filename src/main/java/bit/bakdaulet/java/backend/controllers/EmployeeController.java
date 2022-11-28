package bit.bakdaulet.java.backend.controllers;

import bit.bakdaulet.java.backend.models.EmployeeModel;
import bit.bakdaulet.java.backend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private Environment env;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeModel employeeModel){
       employeeService.createEmployee(employeeModel);
       return new ResponseEntity<String>("Sussecfully created", HttpStatus.OK);
    }

    @GetMapping("/check")
    public String checkController(){
        return "Controller successfully worked on port : " + env.getProperty("local.server.port");
    }
    
    
    @GetMapping("/all")
    public List<EmployeeModel> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public EmployeeModel getEmployeeById(@PathVariable String employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<String> updateEmployeeById(@Valid @RequestBody EmployeeModel employeeModel,
                                                     @PathVariable String employeeId){
        employeeService.updateEmployeeById(employeeId,employeeModel);
        return new ResponseEntity<String>("Succesfully updated",HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable String employeeID){
        employeeService.deleteEmployeeById(employeeID);
        return new ResponseEntity<String>("Succesfully deleted",HttpStatus.OK);
    }


}
