package Controller;

import static Constants.CommonValues.BLANK;
import static Constants.CommonValues.COMMA;
import static Constants.CommonValues.MINIMUM_COIN_VALUE;
import static Constants.CommonValues.REMOVE_REGEX;

import Constants.Coin;
import UI.InputView;
import UI.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vendingmachine.Product;
import vendingmachine.VendingMachine;

public class VendingMachineCreator {
    VendingMachine vendingMachine;
    private int vendingMachineMoney;
    private Map<Coin, Integer> coinBox;
    private List<Product> productShelf;

    public VendingMachine createVendingMachine() {
        createVendingMachineMoney();
        createCoinBox();
        createProductShelf();
        return new VendingMachine(vendingMachineMoney, coinBox, productShelf);
    }

    public void createVendingMachineMoney() {
        vendingMachineMoney = InputView.askVendingMachineMoney();
    }

    public void createCoinBox() {
        coinBox = fillCoinsInBox();
        OutputView.printVendingMachineCoins(coinBox);
    }

    public void createProductShelf() {
        productShelf = fillProducts(InputView.askProductsInfo());
    }

    private List<Product> fillProducts(List<String> productsInfo) {
        List<Product> productShelf = new ArrayList<>();
        for (String productInfo : productsInfo) {
            String[] info = productInfo.replaceAll(REMOVE_REGEX, BLANK).split(COMMA);
            Product product = new Product(info[0], info[1], info[2]);
            productShelf.add(product);
        }
        return productShelf;

    }

    private Map<Coin, Integer> fillCoinsInBox() {
        Map<Coin, Integer> coinBox = new HashMap<>();
        splitMoneyIntoCoins(coinBox);
        return coinBox;
    }

    private void splitMoneyIntoCoins(Map<Coin, Integer> coinBox) {
        for (Coin coin : Coin.values()) {
            int residue = vendingMachineMoney;
            int coinNumber = decideCoinNumber(coin, residue);
            coinBox.put(coin, coinNumber);
            residue -= coin.getAmount() * coinNumber;
            if (residue == 0) {
                return;
            }
        }
    }

    private int decideCoinNumber(Coin coin, int residue) {
        if (coin.getAmount() == MINIMUM_COIN_VALUE) {
            return residue / MINIMUM_COIN_VALUE;
        }
        return Randoms.pickNumberInRange(0, residue / coin.getAmount());
    }
}
