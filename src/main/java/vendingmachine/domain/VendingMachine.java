package vendingmachine.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {

    private static final String ERROR_HEADER = "[ERROR] ";
    private static final String NOT_EXIST_PRODUCT = "구매할 수 있는 상품이 존재하지 않습니다. 자판기에서 구매할 수 있고 존재하는 상품을 입력해주세요. ";

    private final Map<Coin, Integer> coinCount = new HashMap<>();
    private final List<Product> products;
    private int inputMoney;

    public VendingMachine(List<Product> products, int inputMoney, int vendingMachineMoney) {
        this.products = products;
        this.inputMoney = inputMoney;
        createRandomCoinList(vendingMachineMoney);
    }

    public void buyProduct(String inputProductName) {
        Product product = findProudctInVendingMachine(inputProductName);
        inputMoney -= product.getPrice();
        product.buyOneProduct();

    }

    public int getInputMoney() {
        return inputMoney;
    }

    public int getProductsCount() {
        int counts = 0;
        for (Product product : products) {
            counts += product.getCount();
        }
        return counts;
    }

    public int getMinPrice() {
        int minValue = Integer.MAX_VALUE;
        for (Product product : products) {
            if (product.getPrice() < minValue) {
                minValue = product.getPrice();
            }
        }
        return minValue;
    }

    private void createRandomCoinList(int vendingMachineMoney) {
        for (Coin coinName : Coin.values()) {
            coinCount.put(coinName, 0);
        }

        Integer randomCoin;
        while (vendingMachineMoney != 0) {
            randomCoin = Coin.getRandomAmount();
            if (randomCoin <= vendingMachineMoney) {
                vendingMachineMoney -= randomCoin;
                Coin randomCoinName = findCoinByValue(randomCoin);
                coinCount.replace(randomCoinName, coinCount.get(randomCoinName) + 1);
            }
        }
    }

    private Coin findCoinByValue(int coinValue) {
        for (Coin coin : Coin.values()) {
            if (coin.getAmount() == coinValue) {
                return coin;
            }
        }
        return null;
    }

    private Product findProudctInVendingMachine(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName) && inputMoney >= product.getPrice() && product.getCount() > 0) {
                return product;
            }
        }
        throw new IllegalArgumentException(ERROR_HEADER + NOT_EXIST_PRODUCT);
    }

}
