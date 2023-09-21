package pro.sky.hwCollections.service;

import pro.sky.hwCollections.exceptions.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    public Employee addEmployee(String name, String surname);


    public Employee deleteEmployee(String name, String surname) throws Exception;

    public Employee findEmployee(String name, String surname) throws EmployeeNotFoundException;

    public List<Employee> getEmployeeList();
}