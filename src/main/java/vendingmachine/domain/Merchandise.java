package vendingmachine.domain;

import vendingmachine.constant.ErrorMessage;
import vendingmachine.util.NumberValidation;

public class Merchandise extends NumberValidation {
    final static int DECREASE_QUANTITY_VALUE = 1;
    final static int NOT_SAME_NAME_PRICE = 0;
    final static int SOLD_OUT_QUANTITY = 0;

    private String name;
    private int price;
    private int quantity;

    public Merchandise(String name, String price, String quantity) {
        isBlank(name);
        this.name = name;

        numberValidation(price);
        this.price = Integer.parseInt(price);

        numberValidation(quantity);
        this.quantity = Integer.parseInt(quantity);
    }

    public String toString() {
        return name + price + quantity;
    }

    public int getPrice(String merchandiseName) {
        if (isSameName(merchandiseName)) {
            return price;
        }
        return NOT_SAME_NAME_PRICE;
    }

    public void isDuplicate(String merchandiseName) throws IllegalArgumentException {
        if (isSameName(merchandiseName)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_MERCHANDISE_EXIST.print());
        }
    }

    public void purchase(String merchandiseName, int money) {
        if (isSameName(merchandiseName)) {
            isExpensive(money);
            isSoldOut();
            decreaseQuantity();
        }
    }

    public boolean isSameName(String merchandiseName) {
        if (merchandiseName.equals(name)) {
            return true;
        }
        return false;
    }

    public boolean isExpensive(int money) throws IllegalArgumentException {
        if (money < price) {
            throw new IllegalArgumentException();
        }
        return false;
    }

    public boolean isSoldOut() throws IllegalArgumentException {
        if (quantity <= SOLD_OUT_QUANTITY) {
            throw new IllegalArgumentException();
        }
        return false;
    }

    public void decreaseQuantity() {
        this.quantity -= DECREASE_QUANTITY_VALUE;
    }
}
