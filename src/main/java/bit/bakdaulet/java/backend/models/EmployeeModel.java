package bit.bakdaulet.java.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

    private String employeeId;
    @NotNull(message = "Name can not be empty")
    @Size(min=2, max=12,message="Name of employee must be more than 2 and less than 12")
    private String name;
    @NotNull(message = "Surname can not be empty")
    @Size(min=2, max=12,message="Surname of employee must be more than 2 and less than 12")
    private String surname;
    @Email(message = "Incorrect email")
    private String email;
    private String company;
    private String department;
    private String position;
    private double salary;

}
