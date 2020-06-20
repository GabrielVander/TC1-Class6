package Model;

import java.util.UUID;

public class Purchase {
  private String id = UUID.randomUUID().toString();
  private Customer customer;
  private int itemAmount;

  public Purchase(Customer customer, int itemAmount) {
    this.customer = customer;
    this.itemAmount = itemAmount;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public int getItemAmount() {
    return itemAmount;
  }

  public void setItemAmount(int itemAmount) {
    this.itemAmount = itemAmount;
  }
}
