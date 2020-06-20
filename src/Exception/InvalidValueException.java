package Exception;

public class InvalidValueException extends Exception {
  public InvalidValueException() {
    super("Item amount cannot be negative");
  }
}
