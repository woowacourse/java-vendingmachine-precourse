package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.exception.NotEnoughBalanceException;
import java.util.*;
import java.util.stream.Collectors;

public class VendingMachine {

    private int balance = 0;

    private Map<String, Product> productMap = new HashMap<>();

    private Map<Coin, Integer> remainingCoin = new HashMap<Coin, Integer>(){{
        put(Coin.COIN_10, 0);
        put(Coin.COIN_50, 0);
        put(Coin.COIN_100, 0);
        put(Coin.COIN_500, 0);
    }};

    public void addBalance(int balance) {
        this.balance += balance;
    }

    public void generateCoin(int holdingAmount) {
        Coin pickedCoin;
        List<Integer> pickableCoinAmountList = Coin.coinAmountList;

        while (holdingAmount > 0) {
            pickableCoinAmountList = updatePickableCoinAmountList(pickableCoinAmountList, holdingAmount);

            pickedCoin = pickCoin(pickableCoinAmountList);
            addRemainingCoin(pickedCoin);
            holdingAmount -= pickedCoin.getAmount();
        }
    }

    private List<Integer> updatePickableCoinAmountList(List<Integer> pickableCoinAmountList, int upperBoundAmount) {
        return pickableCoinAmountList.stream()
                .filter(amount -> amount <= upperBoundAmount)
                .collect(Collectors.toList());
    }

    private Coin pickCoin(List<Integer> pickableCoinAmountList) {
        int pickedAmount = Randoms.pickNumberInList(pickableCoinAmountList);

        return Coin.of(pickedAmount);
    }

    private void addRemainingCoin(Coin coin) {
        int remainingStock = remainingCoin.get(coin);
        remainingCoin.put(coin, remainingStock + 1);
    }

    public void setProductMap(List<Product> productList) {
        for (Product product : productList) {
            productMap.put(product.getName(), product);
        }
    }

    public void sellProduct(String productName) {
        Product product;

        if (!productMap.keySet().contains(productName)) {
            throw new NoSuchElementException(ErrorMessage.NO_PRODUCT_MATCH.getCompleteMessage());
        }
        product = productMap.get(productName);

        if (balance < product.getPrice()) {
            throw new NotEnoughBalanceException(ErrorMessage.NOT_ENOUGH_BALANCE.getCompleteMessage());
        }
        balance -= product.getPrice();
        product.sell();
        productMap.put(product.getName(), product);
    }

}
