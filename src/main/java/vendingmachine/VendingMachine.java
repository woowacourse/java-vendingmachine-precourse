package vendingmachine;

import static Constants.CommonValues.*;

import Constants.Coin;
import UI.InputView;
import UI.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import DTO.VendingMachineDto;

public class VendingMachine {
    private int vendingMachineMoney;
    private Map<Coin, Integer> coinBox;
    private List<Product> productShelf;

    public VendingMachine() {
        vendingMachineMoney = InputView.askVendingMachineMoney();
        coinBox = fillCoinsInBox(vendingMachineMoney);
        productShelf = fillProducts(InputView.askProductsInfo());
    }

    private Map<Coin, Integer> fillCoinsInBox(int vendingMachineMoney) {
        Map<Coin, Integer> coinBox = new HashMap<>();
        splitMoneyIntoCoins(coinBox);
        return coinBox;
    }

    private void splitMoneyIntoCoins(Map<Coin, Integer> coinBox) {
        for (Coin coin : Coin.values()) {
            int coinNumber = decideCoinNumber(coin);
            coinBox.put(coin, coinNumber);
            vendingMachineMoney -= coin.getAmount() * coinNumber;
            if (vendingMachineMoney == 0) {
                return;
            }
        }
    }

    private int decideCoinNumber(Coin coin) {
        if (coin.getAmount() == MINIMUM_COIN_VALUE) {
            return vendingMachineMoney / MINIMUM_COIN_VALUE;
        }
        return Randoms.pickNumberInRange(0, vendingMachineMoney / coin.getAmount());
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
