package Service;

import Exception.InvalidValueException;
import Exception.LimboException;
import Model.Customer;
import Model.CustomerType;
import Model.Purchase;
import jdk.jfr.Description;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DiscountServiceTest {
  private final DiscountService discountService = new DiscountService();

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 5, 9})
  @Description("Discount is calculated correctly for customer of type A with itemAmount < 10")
  void customerTypeA_LessThanTen(int itemAmount) throws LimboException, InvalidValueException {
    discountService.setPurchase(mockPurchase(CustomerType.A, itemAmount));

    Double expected = 0d;
    Double actual = discountService.calculateDiscount();

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @ValueSource(ints = {10, 11, 55, 98, 99})
  @Description("Discount is calculated correctly for customer of type A with 10 <= itemAmount <= 99")
  void customerTypeA_BetweenTenAndNinetyNine(int itemAmount) throws LimboException, InvalidValueException {
    discountService.setPurchase(mockPurchase(CustomerType.A, itemAmount));

    Double expected = .05;
    Double actual = discountService.calculateDiscount();

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @ValueSource(ints = {101, 102, 999, Integer.MAX_VALUE})
  @Description("Discount is calculated correctly for customer of type A with itemAmount > 100")
  void customerTypeA_GreaterThanOneHundred(int itemAmount) throws LimboException, InvalidValueException {
    discountService.setPurchase(mockPurchase(CustomerType.A, itemAmount));

    Double expected = .1;
    Double actual = discountService.calculateDiscount();

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 5, 9})
  @Description("Discount is calculated correctly for customer of type B with itemAmount < 10")
  void customerTypeB_LessThanTen(int itemAmount) throws LimboException, InvalidValueException {
    discountService.setPurchase(mockPurchase(CustomerType.B, itemAmount));

    Double expected = .05;
    Double actual = discountService.calculateDiscount();

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @ValueSource(ints = {10, 11, 55, 98, 99})
  @Description("Discount is calculated correctly for customer of type B with 10 <= itemAmount <= 99")
  void customerTypeB_BetweenTenAndNinetyNine(int itemAmount) throws LimboException, InvalidValueException {
    discountService.setPurchase(mockPurchase(CustomerType.B, itemAmount));

    Double expected = .15;
    Double actual = discountService.calculateDiscount();

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @ValueSource(ints = {101, 102, 999, Integer.MAX_VALUE})
  @Description("Discount is calculated correctly for customer of type B with itemAmount > 100")
  void customerTypeB_GreaterThanOneHundred(int itemAmount) throws LimboException, InvalidValueException {
    discountService.setPurchase(mockPurchase(CustomerType.B, itemAmount));

    Double expected = .25;
    Double actual = discountService.calculateDiscount();

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 5, 9})
  @Description("Discount is calculated correctly for customer of type C with itemAmount < 10")
  void customerTypeC_LessThanTen(int itemAmount) throws LimboException, InvalidValueException {
    discountService.setPurchase(mockPurchase(CustomerType.C, itemAmount));

    Double expected = 0d;
    Double actual = discountService.calculateDiscount();

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @ValueSource(ints = {10, 11, 55, 98, 99})
  @Description("Discount is calculated correctly for customer of type C with 10 <= itemAmount <= 99")
  void customerTypeC_BetweenTenAndNinetyNine(int itemAmount) throws LimboException, InvalidValueException {
    discountService.setPurchase(mockPurchase(CustomerType.C, itemAmount));

    Double expected = .20;
    Double actual = discountService.calculateDiscount();

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @ValueSource(ints = {101, 102, 999, Integer.MAX_VALUE})
  @Description("Discount is calculated correctly for customer of type C with itemAmount > 100")
  void customerTypeC_GreaterThanOneHundred(int itemAmount) throws LimboException, InvalidValueException {
    discountService.setPurchase(mockPurchase(CustomerType.C, itemAmount));

    Double expected = .25;
    Double actual = discountService.calculateDiscount();

    assertEquals(expected, actual);
  }

  @ParameterizedTest()
  @EnumSource(CustomerType.class)
  void limboException(CustomerType customerType) {
    discountService.setPurchase(mockPurchase(customerType, 100));

    assertThrows(LimboException.class, discountService::calculateDiscount);
  }

  @ParameterizedTest()
  @EnumSource(CustomerType.class)
  void invalidValueException(CustomerType customerType) {
    discountService.setPurchase(mockPurchase(customerType, -1));

    assertThrows(InvalidValueException.class, discountService::calculateDiscount);
  }

  static Purchase mockPurchase(CustomerType customerType, int itemAmount) {
    Customer customer = new Customer("Test", customerType);

    return new Purchase(customer, itemAmount);
  }

}