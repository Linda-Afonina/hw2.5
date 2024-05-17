package pro.sky.employeeAccountingProgram.service;

import pro.sky.employeeAccountingProgram.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
    List<String> employees = new ArrayList<>(List.of());
    int MAX_OF_EMPLOYEES = 10;

    void addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    void findEmployee(String firstName, String lastName);

    List<Employee> printEmployees();
}
