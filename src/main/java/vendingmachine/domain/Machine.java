package vendingmachine.domain;

import vendingmachine.utils.Coin;
import vendingmachine.utils.ErrorMessage;

import java.util.Map;

import static vendingmachine.utils.ErrorMessage.NOT_ENOUGH_CASH;
import static vendingmachine.utils.ErrorMessage.NOT_EXIST_PRODUCT;
import static vendingmachine.utils.MachineConst.MAX_CASH;
import static vendingmachine.utils.MachineConst.MIN_CASH;

public class Machine {

    private int storedCash = 0;
    private final Change change;
    private final Inventory inventory;

    public Machine(int cash) {

        validateChange(cash);
        this.change = new Change(cash);
        this.inventory = new Inventory();
    }

    private void validateChange(int change) {

        if (isOutOfRange(change)) {
            throw new IllegalArgumentException(ErrorMessage.CHANGE_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(int change) {
        return change <= MIN_CASH.get() || change >= MAX_CASH.get();
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public void addCash(int investedCash) {
        this.storedCash += investedCash;
    }

    public void purchase(String name) {

        Product product = inventory.consume(name);
        validatePurchase(product);
        this.storedCash -= product.getAmount();
    }

    private void validatePurchase(Product product) {

        if (isBiggerThanRemainCash(product)) {
            throw new IllegalArgumentException(NOT_ENOUGH_CASH.getMessage());
        }
        if (isNotExistProduct(product)) {
            throw new IllegalArgumentException(NOT_EXIST_PRODUCT.getMessage());
        }
    }

    private boolean isNotExistProduct(Product product) {
        return !inventory.contains(product.getName());
    }

    private boolean isBiggerThanRemainCash(Product product) {
        return storedCash < product.getAmount();
    }

    public Map<Coin, Integer> getReturnChange() {
        return change.getChange(storedCash);
    }

    public Map<Coin, Integer> getStoredChange() {
        return change.getStoredChange();
    }

    public boolean isExhausted() {

        if (inventory.isEmpty()) {
            return true;
        }

        if (isShortCash()) {
            return true;
        }

        return false;
    }

    private boolean isShortCash() {
        return storedCash < inventory.getMinAmount();
    }

    public int getStoredCash() {
        return this.storedCash;
    }
}
