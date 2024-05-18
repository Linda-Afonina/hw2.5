package pro.sky.employeeAccountingProgram.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeeAccountingProgram.Employee;
import pro.sky.employeeAccountingProgram.exceptions.EmployeeAlreadyAddedException;
import pro.sky.employeeAccountingProgram.exceptions.EmployeeNotFoundException;
import pro.sky.employeeAccountingProgram.exceptions.EmployeeStorageIsFullException;
import pro.sky.employeeAccountingProgram.service.EmployeeService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public Collection<Employee> printEmployees() {
        return employeeService.printEmployees();
    }

    @GetMapping("add")
    public Employee addEmployee(@RequestParam("firstname") String firstName,
                                @RequestParam("lastname") String lastName) {

        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("remove")
    public Employee removeEmployee(@RequestParam("firstname") String firstName,
                                   @RequestParam("lastname") String lastName) {

        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("find")
    public Employee findEmployee(@RequestParam("firstname") String firstName,
                                 @RequestParam("lastname") String lastName) {

        return employeeService.findEmployee(firstName, lastName);
    }
}
