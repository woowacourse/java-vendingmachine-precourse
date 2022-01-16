package vendingmachine.domain;

public class Quantity {
  private static final String INVALID_QUANTITY_ERROR_MESSAGE = "[ERROR] 상품 수량은 0이상 입력해야 한다.";

  private int quantity;

  public Quantity(int quantity) {
    validateQuantity(quantity);
    this.quantity = quantity;
  }

  public void decreaseQuantity() {
    quantity--;
  }

  public boolean isQuantityZero() {
    return quantity == 0;
  }

  public static void validateQuantity(int quantity) {
    if (quantity < 0) {
      throw new IllegalArgumentException(INVALID_QUANTITY_ERROR_MESSAGE);
    }
  }


}
