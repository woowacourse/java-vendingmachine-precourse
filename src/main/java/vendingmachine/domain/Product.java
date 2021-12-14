package vendingmachine.domain;

import vendingmachine.util.VendingMachineConstant;

public class Product {
    private String name;
    private int price;
    private int amount;

    public Product(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void purchase(int money) {
        validateCanPurchase(money);
        decreaseAmount();
    }

    private void validateCanPurchase(int money) {
        isMoreExpensive(money);
        isSoldOut();
    }

    private void isMoreExpensive(int money) {
        if (money < price) {
            throw new IllegalArgumentException(VendingMachineConstant.ERROR_PREFIX_MESSAGE + VendingMachineConstant.NOT_ENOUGH_MONEY);
        }
    }

    private void isSoldOut() throws IllegalArgumentException {
        if (amount == VendingMachineConstant.SOLD_OUT_AMOUNT) {
            throw new IllegalArgumentException(VendingMachineConstant.ERROR_PREFIX_MESSAGE + VendingMachineConstant.NOT_ENOUGH_AMOUNT);
        }
    }

    public void decreaseAmount() {
        this.amount -= VendingMachineConstant.DECREASE_AMOUNT_VALUE;
    }
}
