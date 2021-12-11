package vendingmachine.domain.machine;

import vendingmachine.domain.coin.CoinPocket;
import vendingmachine.domain.coin.util.CoinProvider;
import vendingmachine.domain.consumer.Consumer;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductStore;
import vendingmachine.util.RegexSeparator;

import java.util.List;

public class VendingMachine {
    private final ProductStore productStore;
    private final CoinPocket coinPocket;
    private final String BY = ";";

    private int balance;

    public static VendingMachine of(int balance) {
        return new VendingMachine(balance);
    }

    private VendingMachine(int balance) {
        this.balance = balance;
        this.productStore = ProductStore.getInstance();
        this.coinPocket = CoinPocket.getInstance();
    }

    public void fillCoinsAsBalanceAmount(CoinProvider coinProvider) {
        while(balance > 0) {
            reduceBalance(coinPocket.putCoinAndAddCount(balance, coinProvider));
        }
    }

    private void reduceBalance(int coinAmount) {
        balance -= coinAmount;
    }

    public void splitInfoAndFillProduct(String allProductInfo) {
        for (String eachProductInfo : splitAllProductInfo(allProductInfo)) {
            productStore.putProduct(
                    RegexSeparator.getNameFromProductInfo(eachProductInfo),
                    RegexSeparator.mapInfoToProduct(eachProductInfo));
        }
    }

    private String[] splitAllProductInfo(String allProductInfo) {
        return allProductInfo.split(BY);
    }

    // for test
    public boolean isEqualBalance(int balance) {
        return this.balance == balance;
    }

    // for test
    public boolean hasProduct(List<String> productNameList) {
        return productNameList.stream()
                .allMatch((productName) -> productStore.hasProduct(productName));
    }

    public void makeChange(int changeAmount) {
        coinPocket.makeCoinCountMin(changeAmount);
    }

    public Product getProduct(String readProductName) {
        return productStore.getProduct(readProductName);
    }

    public boolean verifyConsumerCanBuyAnyProduct(Consumer consumer) {
        return productStore.verifyEnoughConsumerBalance(consumer);
    }
}
