package pro.sky.hwCollections.service;

import org.springframework.stereotype.Service;
import pro.sky.hwCollections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.hwCollections.exceptions.EmployeeNotFoundException;
import pro.sky.hwCollections.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employeeList;
    private static final int MAX_EMPLOYEES = 3;

    public EmployeeServiceImpl(List<Employee> employeeList) {
        this.employeeList = new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }


    @Override
    public Employee addEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Employee already added");
        }
        if (employeeList.size() < MAX_EMPLOYEES) {
            employeeList.add(employee);
        } else {
            throw new EmployeeStorageIsFullException("Storage is already full, bitch");
        }
        return employee;
    }


    @Override
    public Employee deleteEmployee(String name, String surname) {
        Employee foundEmployee;
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            if (name.equals(employee.getName()) && surname.equals(employee.getSurname())) {
                foundEmployee = employee;
                employeeIterator.remove();
                return foundEmployee;
            }
        }
        throw new EmployeeNotFoundException("Employee not found, glupishka");
    }

    @Override
    public Employee findEmployee(String name, String surname) {
        Employee findEmployee;
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            if (name.equals(employee.getName()) && surname.equals(employee.getSurname())) {
                findEmployee = employee;
                return findEmployee;
            }
        }
        throw new EmployeeNotFoundException("Employee not found, glupishka");
    }
}