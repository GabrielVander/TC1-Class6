package Model;

public class Customer {
  private String name;
  private CustomerType type;

  public Customer(String name, CustomerType type) {
    this.name = name;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CustomerType getType() {
    return type;
  }

  public void setType(CustomerType type) {
    this.type = type;
  }
}
