package vendingmachine.validator;

public class ProductValidator {
    public static final int PRICE_MINIMUM = 100;
    public static final int PRICE_UNIT = 10;
    public static final int NAME_MAX_LENGTH = 30;

    public void isValidPrice(int money) {
        if (money % PRICE_UNIT != 0 || money < PRICE_MINIMUM) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidName(String name) {
        if (name.length() > NAME_MAX_LENGTH || name.length() == 0) {
            throw new IllegalArgumentException();
        }
    }
}
