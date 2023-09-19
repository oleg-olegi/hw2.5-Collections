package pro.sky.hwCollections.servise;

public interface EmployeeService {
    public void addEmployee(String name, String surname);


    public void deleteEmployee(String name, String surname);

    public String findEmployee(String name, String surname);

}
