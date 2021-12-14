package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;


public class VendingMachine {
    private final static int MAXIMUM_PRODUCT_PRICE = 100_000_001;
    private int minimumPrice;
    private Map<Coin, Integer> coinHashMap;
    private Map<String, Product> productMap;
    private Customer customer;

    public VendingMachine(int inputMoney) {
        minimumPrice = MAXIMUM_PRODUCT_PRICE;
        coinHashMap = generateRandomCoins(inputMoney);
        productMap = new HashMap<>();
    }

    public void settingPutMoneyCustomer(Customer customer) {
        this.customer = customer;
    }

    private Map<Coin, Integer> generateRandomCoins(int inputMoney) {
        Map<Coin, Integer> newCoinHashMap = new LinkedHashMap<>();
        while (inputMoney != 0) {
            inputMoney = extractCoin(inputMoney, newCoinHashMap);
        }
        return newCoinHashMap;
    }

    private int extractCoin(int inputMoney, Map<Coin, Integer> newCoinHashMap) {
        for (Coin coin : Coin.values()) {
            int randomQuotient = Randoms.pickNumberInRange(0, inputMoney / coin.getAmount());
            inputMoney -= (randomQuotient * coin.getAmount());
            newCoinHashMap.put(coin, newCoinHashMap.getOrDefault(coin, 0) + randomQuotient);
        }
        return inputMoney;
    }

    public void saveProduct(List<Product> products) {
        for (Product product : products) {
            if (productMap.containsKey(product.getName())) {
                throw new IllegalArgumentException();
            }
            productMap.put(product.getName(), product);
            minimumPrice = Math.min(minimumPrice, product.getPrice());
        }
    }

    @Override
    public String toString() {
        StringBuilder results = new StringBuilder();
        results.append("자판기가 보유한 동전").append("\n");
        for (Coin holdingCoin : coinHashMap.keySet()) {
            results.append(holdingCoin.toString()).append(" - ").append(coinHashMap.get(holdingCoin)).append("개").append("\n");
        }
        return results.toString();
    }

    public String toStringCustomerInputMoney() {
        return customer.toString();
    }

    public boolean isProductsAvailableForPurchase() {
        return customer.getInputMoneyToVendingMachine() >= minimumPrice;
    }

    public boolean pay(String productName) {
        Product orderProduct = productMap.get(productName);
        try {
            orderProduct.reduceStock();
        } catch (IllegalArgumentException e) {
            return false;
        }
        reduceCustomerInputMoney(orderProduct.getPrice());
        return true;
    }

    private void reduceCustomerInputMoney(int deductMoney) {
        this.customer.deductTheMoney(deductMoney);
    }

    public String printCustomerChange() {
        Map<Coin, Integer> resultCoinMap = returnCoinToTheCustomer();
        StringBuilder results = new StringBuilder();
        results.append("잔돈").append("\n");
        for (Coin coin : resultCoinMap.keySet()) {
            results.append(coin).append(" - ").append(resultCoinMap.get(coin)).append("\n");
        }
        return results.toString();
    }

    private void deductHoldingCoin(Coin coin, int quantity) {
        coinHashMap.put(coin, coinHashMap.get(coin) - quantity);
    }

    private Map<Coin, Integer> returnCoinToTheCustomer() {
        Map<Coin, Integer> changes = new LinkedHashMap<>();
        for (Coin coin : Coin.values()) {
            int returnCoinToTheCustomer = calculateCoinUsingAmount(coin);
            if (returnCoinToTheCustomer == 0) {
                continue;
            }
            deductHoldingCoin(coin, returnCoinToTheCustomer);
            reduceCustomerInputMoney(returnCoinToTheCustomer * coin.getAmount());
            changes.put(coin, returnCoinToTheCustomer);
        }
        return changes;
    }

    private int calculateCoinUsingAmount(Coin coin) {
        int quotient = customer.getInputMoneyToVendingMachine() / coin.getAmount();
        Integer restQuantity = coinHashMap.get(coin);
        if (quotient > restQuantity) {
            return restQuantity;
        }
        return quotient;
    }
}
