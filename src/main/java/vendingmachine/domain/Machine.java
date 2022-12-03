package vendingmachine.domain;

import vendingmachine.Coin;
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

    public Machine(int exchange) {
        validateExchange(exchange);
        this.change = new Change(exchange);
        this.inventory = new Inventory();
    }

    private void validateExchange(int exchange) {
        if (isOutOfRange(exchange)) {
            throw new IllegalArgumentException(ErrorMessage.EXCHANGE_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(int exchange) {
        return exchange <= MIN_CASH.getValue() || exchange >= MAX_CASH.getValue();
    }

    public void storeProduct(Product product) {
        inventory.add(product);
    }

    public void storeCash(int investedCash) {
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

    public Map<Coin, Integer> getExchangeResult() {
        return change.getExchange(storedCash);
    }

    public Map<Coin, Integer> getCurrentExchange() {
        return change.getCash();
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

    public int getRemainCoin() {
        return this.storedCash;
    }
}
