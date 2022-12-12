package vendingmachine.controller;

import vendingmachine.Validator;
import vendingmachine.util.Constant;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Machine;
import vendingmachine.domain.Product;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainController {
    public void run() {
        Machine machine = new Machine();
        List<Product> products = new ArrayList<>();
        LinkedHashMap<Coin, Integer> coinMap = machine.getCoins();
        generateMachineHasCoins(machine);
        OutputView.printMachineHasCoins(coinMap);
        createProductInfo(products);
        int minProductPrice = getMinProductPrice(products);
        int userMoneyInput = InputView.inputMoney();
        LinkedHashMap<Coin, Integer> changeCoins = setChangeMap();
        while (userMoneyInput > minProductPrice) {
            userMoneyInput = purchaseProduct(products, userMoneyInput);
        }
        OutputView.printCurrentInputMoney(userMoneyInput);

        makeChange(coinMap, changeCoins, userMoneyInput);
        OutputView.printChange(changeCoins);
    }

    private static void makeChange(Map<Coin, Integer> coinMap, Map<Coin, Integer> changeCoins, int userMoneyInput) {
        while (userMoneyInput != 0) {
            if (hasCoin(coinMap, userMoneyInput, 500)) {
                calculateChange(coinMap, 500, changeCoins);
                userMoneyInput -= 500;
                continue;
            }
            if (hasCoin(coinMap, userMoneyInput, 100)) {
                calculateChange(coinMap, 100, changeCoins);
                userMoneyInput -= 100;
                continue;
            }
            if (hasCoin(coinMap, userMoneyInput, 50)) {
                calculateChange(coinMap, 50, changeCoins);
                userMoneyInput -= 50;
                continue;
            }
            if (hasCoin(coinMap, userMoneyInput, 10)) {
                calculateChange(coinMap, 10, changeCoins);
                userMoneyInput -= 10;
                continue;
            }
            if (checkRemainingCoins(coinMap)) break;
        }
    }

    private static boolean hasCoin(Map<Coin, Integer> coinMap, int userMoneyInput, int coin) {
        return userMoneyInput >= coin && coinMap.get(Coin.valueOf(coin)) > 0;
    }

    private static void createProductInfo(List<Product> products) {
        String[] productsInput = InputView.inputProductDetail().split(";");
        insertProduct(products, productsInput);
    }

    private static int purchaseProduct(List<Product> products, int userMoneyInput) {
        OutputView.printCurrentInputMoney(userMoneyInput); // 현재 잔액을 출력함
        String purchasingProduct = InputView.inputPurchaseProduct(); // 어떤 상품을 구매할껀지 입력
        Product inputProduct = getProduct(products, purchasingProduct);
        int productPrice = inputProduct.getPrice();
        userMoneyInput -= productPrice;
        return userMoneyInput;
    }

    private static void generateMachineHasCoins(Machine machine) {
        int machineInputMoney = InputView.inputMachineHoldMoney(); // 1. 자판기 돈 입력
        machine.generateCoin(machineInputMoney);
    }


    private static int generateChange(Map<Coin, Integer> coinMap, int userMoneyInput ,Map<Coin, Integer> changeCoins) {
        calculateChange(coinMap, 10, changeCoins);
        userMoneyInput -= 10;
        return userMoneyInput;
    }

    private static boolean checkRemainingCoins(Map<Coin, Integer> coinMap) {
        return coinMap.get(Coin.COIN_500) == 0 && coinMap.get(Coin.COIN_100) == 0 && coinMap.get(Coin.COIN_50) == 0 && coinMap.get(Coin.COIN_10) == 0;
    }

    private static int getMinProductPrice(List<Product> products) {
        int minProductPrice = products.get(0).getPrice();
        for (int i = 1; i < products.size(); i++) {
            if (minProductPrice > products.get(i).getPrice()) {
                minProductPrice = products.get(i).getPrice();
            }
        }
        return minProductPrice;
    }

    private static void insertProduct(List<Product> products, String[] productsInput) {
        for (String product : productsInput) {
            String productDetail = product.replaceAll(Constant.REGEX, "");
            String[] productInfo = productDetail.split(",");
            Product freshProduct = new Product(productInfo[0], Integer.parseInt(productInfo[1]), Integer.parseInt(productInfo[2]));
            products.add(freshProduct);
        }
    }

    private static LinkedHashMap<Coin, Integer> setChangeMap() {
        LinkedHashMap<Coin, Integer> changeCoins = new LinkedHashMap<>();
        setChangeMap(changeCoins);
        return changeCoins;
    }

    private static Product getProduct(List<Product> products, String purchasingProduct) {
        Product inputProduct = products.stream() //
                .filter(x -> x.getName().equals(purchasingProduct))
                .findFirst()
                .orElse(null);
        Validator.validateProduct(inputProduct);
        return inputProduct;
    }

    private static void calculateChange(Map<Coin, Integer> coinMap, int inputCoin, Map<Coin, Integer> changeCoins) {
        Coin coin = Coin.valueOf(inputCoin);
        coinMap.put(coin, coinMap.get(coin) - 1);
        changeCoins.put(coin, changeCoins.get(coin) + 1);
    }

    private static void setChangeMap(Map<Coin, Integer> coinsMap) {
        coinsMap.put(Coin.COIN_500, 0);
        coinsMap.put(Coin.COIN_100, 0);
        coinsMap.put(Coin.COIN_50, 0);
        coinsMap.put(Coin.COIN_10, 0);
    }
}
