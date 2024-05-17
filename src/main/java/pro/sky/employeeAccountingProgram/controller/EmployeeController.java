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

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> print() {
        return employeeService.printEmployees();
    }

    @GetMapping("add")
    public EmployeeService add(@RequestParam("firstname") String firstName,
                               @RequestParam("lastname") String lastName) {
        try {
            employeeService.addEmployee(firstName, lastName);
        } catch (EmployeeStorageIsFullException | EmployeeAlreadyAddedException e) {
            System.out.println(e.getMessage());
        }
        return employeeService;
    }

    @GetMapping("remove")
    public EmployeeService remove(@RequestParam("firstname") String firstName,
                                  @RequestParam("lastname") String lastName) {
        try {
            employeeService.removeEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return employeeService;
    }

    @GetMapping("find")
    public EmployeeService find(@RequestParam("firstname") String firstName,
                                @RequestParam("lastname") String lastName) {
        try {
            employeeService.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return employeeService;
    }
}
