package Service;

import Exception.InvalidValueException;
import Exception.LimboException;
import Model.Purchase;

public class DiscountService {
  private Purchase purchase;

  public DiscountService() {

  }

  public DiscountService(Purchase purchase) {
    this.purchase = purchase;
  }

  public Double calculateDiscount() throws LimboException, InvalidValueException {
    int itemAmount = purchase.getItemAmount();

    if(itemAmount < 0) throw new InvalidValueException();

    switch (purchase.getCustomer().getType()) {
      case A:
        if(itemAmount > 100) return .1;
        if(itemAmount >= 10 && itemAmount <= 99) return .05;
        if(itemAmount < 10) return .0;
        throw new LimboException();

      case B:
        if(itemAmount > 100) return .25;
        if(itemAmount >= 10 && itemAmount <= 99) return .15;
        if(itemAmount < 10) return .05;
        throw new LimboException();

      case C:
        if(itemAmount > 100) return .25;
        if(itemAmount >= 10 && itemAmount <= 99) return .20;
        if(itemAmount < 10) return .0;
        throw new LimboException();

      default:
        return 0d;
    }
  }

  public Purchase getPurchase() {
    return purchase;
  }

  public void setPurchase(Purchase purchase) {
    this.purchase = purchase;
  }
}
