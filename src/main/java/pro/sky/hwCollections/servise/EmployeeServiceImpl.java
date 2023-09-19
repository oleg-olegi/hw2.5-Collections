package pro.sky.hwCollections.servise;

import org.springframework.stereotype.Service;

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
        if (employeeList.size() < MAX_EMPLOYEES) {
            employeeList.add(new Employee(name, surname));
        }
    }

    @Override
    public void deleteEmployee(String name, String surname) {
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            if (name.equals(employee.getName()) && surname.equals(employee.getSurname())) {
                employeeIterator.remove();
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
        return "Employee not found";
    }
}
