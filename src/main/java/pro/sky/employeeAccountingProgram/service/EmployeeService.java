package pro.sky.employeeAccountingProgram.service;

import pro.sky.employeeAccountingProgram.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    List<String> employees = new ArrayList<>(List.of());
    int MAX_OF_EMPLOYEES = 10;

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> printEmployees();
}
