package pro.sky.hwCollections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hwCollections.exceptions.EmployeeNotFoundException;
import pro.sky.hwCollections.service.Employee;
import pro.sky.hwCollections.service.EmployeeService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/employee")
public class Controller {
    private final EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("name") String name,
                                @RequestParam("surname") String surname) {
        return employeeService.addEmployee(name, surname);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("name") String name,
                                   @RequestParam("surname") String surname) throws Exception {
        return employeeService.deleteEmployee(name, surname);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("name") String name,
                                 @RequestParam("surname") String surname) {
        return employeeService.findEmployee(name, surname);
    }

    @GetMapping("/list")
    public List listOfEmployees() {
        return employeeService.getEmployeeList();
    }
}