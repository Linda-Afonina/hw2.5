package pro.sky.employeeAccountingProgram.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.employeeAccountingProgram.Employee;
import pro.sky.employeeAccountingProgram.exceptions.EmployeeAlreadyAddedException;
import pro.sky.employeeAccountingProgram.exceptions.EmployeeNotFoundException;
import pro.sky.employeeAccountingProgram.exceptions.EmployeeStorageIsFullException;
import pro.sky.employeeAccountingProgram.service.EmployeeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Новикова", "Елена Геннадьевна"),
            new Employee("Голиков", "Сергей Иванович"),
            new Employee("Кондратьев", " Олег Петрович"),
            new Employee("Соколова", "Инна"),
            new Employee("Петров", "Алексей"),
            new Employee("Григорьев", "Кирилл Александрович"),
            new Employee("Нестерова", "Ольга Михайловна"),
            new Employee("Меньшов", "Кирилл Александрович"),
            new Employee("Меньшова", "Наталья Юрьевна")
//            new Employee("Королькова", "Светлана Николаевна")
    ));

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= MAX_OF_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже был добавлен.");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
        return employee;
    }

    @Override
    public Collection<Employee> printEmployees() {
        return new ArrayList<>(employees);
    }
}



