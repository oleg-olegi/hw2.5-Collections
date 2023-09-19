package pro.sky.hwCollections.exceptions;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }

    public EmployeeAlreadyAddedException(RuntimeException cause) {
        super(cause);
    }
}
