package pro.sky.hwCollections.servise;

import ch.qos.logback.classic.spi.IThrowableProxy;
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
    public void deleteEmployee(String name, String surname) {
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            if (name.equals(employee.getName()) && surname.equals(employee.getSurname())) {
                employeeIterator.remove();
            } else {
                throw new EmployeeNotFoundException("Employee not found, glupishka");
            }
        }
    }

    @Override
    public String findEmployee(String name, String surname) {
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            if (name.equals(employee.getName()) && surname.equals(employee.getSurname())) {
                return employee.toString();
            }
        }
        throw new EmployeeNotFoundException("Employee not found, glupishka");
    }
}
