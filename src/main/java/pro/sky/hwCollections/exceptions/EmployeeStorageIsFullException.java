package pro.sky.hwCollections.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }

    public EmployeeStorageIsFullException(RuntimeException cause) {
        super(cause);
    }
}
