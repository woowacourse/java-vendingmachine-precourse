package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.utils.Exception;
import vendingmachine.utils.NumberValidator;
import vendingmachine.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachine {

    private final HashMap<Integer, Integer> coinTable = new HashMap<>();
    private final List<Product> products = new ArrayList<>();
    private Money money;

    public void generateCoins(String inputMoney) {
        validateVendingMachineMoney(inputMoney);
        generateRandomCoin(inputMoney);
    }

    private void generateRandomCoin(String inputMoney) {
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
        validateExistProduct(productName);
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
        OutputView.printRemainingAmount(getMoney());
        return false;
    }

    private void validateExistProduct(String productName) {
        if (!isProductExistName(productName)) {
            throw new IllegalArgumentException(Exception.PRODUCT_NO_NAME_EXCEPTION_MESSAGE);
        }
    }

    private boolean isProductExistName(String productName) {
        return products.stream()
                .map(Product::getName)
                .collect(Collectors.toList())
                .contains(productName);
    }

    private void validateVendingMachineMoney(String price) {
        if (!NumberValidator.validateNumber(price)) {
            throw new IllegalArgumentException(Exception.NUMBER_EXCEPTION_MESSAGE);
        }
        if (!NumberValidator.checkDivideTen(price)) {
            throw new IllegalArgumentException(Exception.NUMBER_DIVIDE_TEM_EXCEPTION_MESSAGE);
        }
    }
}
