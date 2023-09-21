package pro.sky.hwCollections.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hwCollections.exceptions.EmployeeNotFoundException;
import pro.sky.hwCollections.service.Employee;
import pro.sky.hwCollections.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class Controller {
    private final EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestParam("name") String name,
                                         @RequestParam("surname") String surname) {
        // try {
        employeeService.addEmployee(name, surname);
        Employee employee = new Employee(name, surname);
        return ResponseEntity.ok(employee);
        //  } catch (EmployeeStorageIsFullException e) {
        //    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Array is full, glupishka:-)");
        //} catch (EmployeeAlreadyAddedException e) {
        //  return ResponseEntity.status(HttpStatus.CONFLICT).body("Employee already added");
        //}
    }

    @GetMapping("/remove")
    public ResponseEntity<?> removeEmployee(@RequestParam("name") String name,
                                            @RequestParam("surname") String surname) throws Exception {
        try {
            Employee removedEmployee = employeeService.deleteEmployee(name, surname);
            return ResponseEntity.ok(removedEmployee);
        } catch (EmployeeNotFoundException e) {
            return new ResponseEntity("Employee not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find")
    public ResponseEntity<?> findEmployee(@RequestParam("name") String name,
                                          @RequestParam("surname") String surname) throws EmployeeNotFoundException {
        try {
            Employee findEmployee = employeeService.findEmployee(name, surname);
            return ResponseEntity.ok(findEmployee);
        } catch (EmployeeNotFoundException e) {
            return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> listOfEmployees() {
        List<Employee> employeeList = employeeService.getEmployeeList();
        return ResponseEntity.ok(employeeList);
    }
}