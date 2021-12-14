package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;


public class VendingMachine {
    private int minimumPrice;
    private Map<Coin, Integer> coinHashMap;
    private Map<String, Product> productMap;
    private Customer customer;

    public VendingMachine(int inputMoney) {
        minimumPrice = 0;
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
}
