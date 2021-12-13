package vendingmachine.validator;

public class ProductValidator {
    public static final int PRICE_MINIMUM = 100;
    public static final int PRICE_UNIT = 10;
    public static final int NAME_MAX_LENGTH = 30;

    public int checkPrice(int money) {
        if (money % PRICE_UNIT != 0 || money < PRICE_MINIMUM) {
            throw new IllegalArgumentException();
        }
        return money;
    }

    public int checkStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException();
        }
        return stock;
    }

    public String checkName(String name) {
        if (name.length() > NAME_MAX_LENGTH || name.length() == 0) {
            throw new IllegalArgumentException();
        }
        return name;
    }
}
