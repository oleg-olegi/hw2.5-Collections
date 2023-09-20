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
    private static final int MAX_EMPLOYEES = 5;

    public EmployeeServiceImpl(List<Employee> employeeList) {
        this.employeeList = new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }


    @Override
    public void addEmployee(String name, String surname) {
        for (Employee employee : employeeList) {
            if (employee.getName().equals(name) && employee.getSurname().equals(surname)) {
                throw new EmployeeAlreadyAddedException("Employee already added");
            }
        }
        if (employeeList.size() < MAX_EMPLOYEES) {
            employeeList.add(new Employee(name, surname));
        } else {
            throw new EmployeeStorageIsFullException("Storage is already full, bitch");
        }
    }

    @Override
    public Employee deleteEmployee(String name, String surname) {
        Employee foundEmployee = null;
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            if (name.equals(employee.getName()) && surname.equals(employee.getSurname())) {
                foundEmployee = employee;
                employeeIterator.remove();
            }
        }
        if (foundEmployee == null) {
            throw new EmployeeNotFoundException("Employee not found, glupishka");
        }
        return foundEmployee;
    }

    @Override
    public Employee findEmployee(String name, String surname) {
        Employee findEmployee = null;
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            if (name.equals(employee.getName()) && surname.equals(employee.getSurname())) {
                findEmployee = employee;
                return findEmployee;
            }
        }
        if (findEmployee == null) {
            throw new EmployeeNotFoundException("Employee not found, glupishka");
        }
        return findEmployee;
    }
}