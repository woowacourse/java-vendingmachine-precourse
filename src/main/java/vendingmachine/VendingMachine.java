package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import static Constants.CommonValues.FALSE;
import static Constants.CommonValues.MINIMUM_COIN_VALUE;

import Constants.Coin;

import UI.InputView;
import UI.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private int vendingMachineMoney;
    private Map<Coin, Integer> coinBox;
    private List<Product> productShelf;

    public VendingMachine() {
        vendingMachineMoney = InputView.askVendingMachineMoney();
        coinBox = fillCoins(vendingMachineMoney);
        productShelf = fillProducts(InputView.askProductsInfo());
    }

    private Map<Coin, Integer> fillCoins(int vendingMachineMoney) {
        Map<Coin, Integer> coinBox = new HashMap<>();
        distributeMoney(vendingMachineMoney, coinBox);
        OutputView.printVendingMachineCoins(coinBox);
        return coinBox;
    }

    private static void distributeMoney(int vendingMachineMoney, Map<Coin, Integer> coinBox) {
        int coinSize;
        for (Coin coin : Coin.values()) {
            if (coin.getAmount() == MINIMUM_COIN_VALUE) {
                coinSize = vendingMachineMoney / MINIMUM_COIN_VALUE;
                coinBox.put(coin, coinSize);
                break;
            }
            coinSize = Randoms.pickNumberInRange(0, vendingMachineMoney / coin.getAmount());
            vendingMachineMoney -= coin.getAmount() * coinSize;
            coinBox.put(coin, coinSize);
        }
    }

    private List<Product> fillProducts(List<String> productsInfo) {
        List<Product> productShelf = new ArrayList<>();
        for (String productInfo : productsInfo) {
            productInfo = productInfo.replaceAll("\\[|\\]", "");
            String[] info = productInfo.split(",");
            Product product = new Product(info[0], info[1], info[2]);
            productShelf.add(product);
        }
        return productShelf;
    }

    public int hasSuchProduct(String wishList) {
        for (Product product : productShelf) {
            if (product.askName().equals(wishList)) {
                return productShelf.indexOf(product);
            }
        }
        return FALSE;
    }

    public List<Product> getShelf() {
        return productShelf;
    }

    public int getPrice(String wishList) {
        int targetIndex = hasSuchProduct(wishList);
        Product product = productShelf.get(targetIndex);
        return product.askPrice();
    }

    public void decreaseStock(String wishList) {
        int targetIndex = hasSuchProduct(wishList);
        Product product = productShelf.get(targetIndex);
        product.sellProduct();
    }

    public void returnChanges(Customer customer) {
        ChangeCalculator changeCalculator = new ChangeCalculator(vendingMachineMoney, coinBox, customer);
        Map<Coin, Integer> result = changeCalculator.calculateResult();
        OutputView.showReturningChanges(result, customer.getInputMoney());
    }
}
