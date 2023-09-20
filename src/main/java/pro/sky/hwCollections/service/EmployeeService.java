package pro.sky.hwCollections.service;

import java.util.List;

public interface EmployeeService {
    public void addEmployee(String name, String surname);


    public Employee deleteEmployee(String name, String surname);

    public Employee findEmployee(String name, String surname);

    public List<Employee> getEmployeeList();
}