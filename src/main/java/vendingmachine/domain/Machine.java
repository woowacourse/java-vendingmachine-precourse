package vendingmachine.domain;

import vendingmachine.Coin;

import java.util.Map;

import static vendingmachine.utils.ErrorMessage.NOT_ENOUGH_CASH;
import static vendingmachine.utils.ErrorMessage.NOT_EXIST_PRODUCT;

public class Machine {

    private final Exchange exchange;
    private int investedCash = 0;
    private final Inventory inventory;

    Machine(int exchange) {
        this.exchange = new Exchange(exchange);
        this.inventory = new Inventory();
    }

    public void storeProduct(Product product) {
        inventory.add(product);
    }

    public void putCash(int investedCash) {
        this.investedCash += investedCash;
    }

    public void purchase(String name) {
        Product product = inventory.consume(name);
        validatePurchase(product);

        this.investedCash -= product.getAmount();
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
        return investedCash < product.getAmount();
    }

    public Map<Coin, Integer> getExchangeResult() {
        return exchange.getExchange(investedCash);
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
        return investedCash < inventory.getMinAmount();
    }

}
