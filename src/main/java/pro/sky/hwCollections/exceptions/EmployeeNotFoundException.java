package pro.sky.hwCollections.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }

    public EmployeeNotFoundException(RuntimeException cause) {
        super(cause);
    }
}
