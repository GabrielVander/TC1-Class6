package Exception;

public class LimboException extends Exception {
  public LimboException() {
    super("Use cases don't cover customers with 100 items");
  }
}
