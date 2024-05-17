package pro.sky.employeeAccountingProgram.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.employeeAccountingProgram.Employee;
import pro.sky.employeeAccountingProgram.exceptions.EmployeeAlreadyAddedException;
import pro.sky.employeeAccountingProgram.exceptions.EmployeeNotFoundException;
import pro.sky.employeeAccountingProgram.exceptions.EmployeeStorageIsFullException;
import pro.sky.employeeAccountingProgram.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>(List.of(
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
    public void addEmployee(String firstName, String lastName) {
        if (employees.size() >= MAX_OF_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме");
        }
        for (Employee element : employees) {
            if (element.getFirstName().equals(firstName) && element.getLastName().equals(lastName)) {
                throw new EmployeeAlreadyAddedException("Сотрудник уже был добавлен.");
            }
            employees.add(new Employee(firstName, lastName));
        }
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (Employee element : employees) {
            if (employees.contains(employee)) {
                employees.remove(element);
            } else throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    @Override
    public void findEmployee(String firstName, String lastName) {
        for (Employee element : employees) {
            if (element.getFirstName().equals(firstName) && element.getLastName().equals(lastName)) {
                System.out.println(element);
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден.");
    }

    @Override
    public List<Employee> printEmployees() {
        return employees;
    }
}



