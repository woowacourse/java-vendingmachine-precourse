package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendingMachine {

    private final HashMap<Integer, Integer> coinTable = new HashMap<>();
    private List<Product> products = new ArrayList<>();
    private Money money;

    public void generateRandomCoin(String inputMoney) {
        int money = Integer.parseInt(inputMoney);
        initCoinTable();
        while (money > 0) {
            int randomNum = Randoms.pickNumberInList(new ArrayList<>(coinTable.keySet()));
            if (randomNum <= money) {
                coinTable.put(randomNum, coinTable.get(randomNum) + 1);
                money -= randomNum;
            }
        }
    }

    private void initCoinTable() {
        for (Coin coin : Coin.values()) {
            coinTable.put(coin.getAmount(), 0);
        }
    }

    public HashMap<Integer, Integer> getCoin() {
        return coinTable;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void insertMoney(Money money) {
        this.money = money;
    }

    public Money getMoney() {
        return money;
    }

    public void buyProduct(String productName) {
        for (Product product : products) {
            if (product.isProduct(productName)) {
                product.decreaseProduct();
                money.decreaseMoney(product.getPrice());
                break;
            }
        }
    }

    public boolean checkAdditionalPurchase() {
        for (Product product : products) {
            if (product.isSoldOut()) {
                continue;
            }
            if (money.isAvailableForPurchase(product.getPrice())) {
                return true;
            }
        }
        return false;
    }

}
