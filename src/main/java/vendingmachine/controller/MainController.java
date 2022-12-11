package vendingmachine.controller;

import vendingmachine.Constant;
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
        LinkedHashMap<Coin, Integer> coinMap = machine.getCoins();
        int machineInputMoney = InputView.inputMachineHoldMoney(); // 1. 자판기 돈 입력
        machine.generateCoin(machineInputMoney);
        OutputView.printMachineHasCoins(coinMap);

        List<Product> products = new ArrayList<>();
        OutputView.printProductDetailInputMsg();
        String[] productsInput = InputView.inputProductDetail().split(";"); // 2. 상품입력
        for (String product : productsInput) {
            String productDetail = product.replaceAll(Constant.REX, "");
            String[] productInfo = productDetail.split(",");
            Product freshProduct = new Product(productInfo[0], Integer.parseInt(productInfo[1]), Integer.parseInt(productInfo[2]));
            products.add(freshProduct);
        }
        int minProductPrice = products.get(0).getPrice();
        for (int i = 1; i < products.size(); i++) {
            if (minProductPrice > products.get(i).getPrice()) {
                minProductPrice = products.get(i).getPrice();
            }
        }
        OutputView.printInputMoneyMsg();
        int userMoneyInput = InputView.inputMoney();
        LinkedHashMap<Coin, Integer> changeCoins = new LinkedHashMap<>();
        setChangeMap(changeCoins);
        while (userMoneyInput > minProductPrice) {
            OutputView.printCurrentInputMoney(userMoneyInput); // 현재 잔액을 출력함
            OutputView.printPurchaseProductInputMsg();
            String purchasingProduct = InputView.inputPurchaseProduct(); // 어떤 상품을 구매할껀지 입력
            Product inputProduct = products.stream() //
                    .filter(x -> x.getName().equals(purchasingProduct))
                    .findFirst()
                    .orElse(null);
            if(inputProduct == null) {
                throw new IllegalArgumentException("[ERROR]");
            }
            int productPrice = inputProduct.getPrice();
            userMoneyInput -= productPrice;

//            while (true) {
//                if (productPrice >= 500 && coinMap.get(Coin.COIN_500) > 0) {
//                    coinMap.put(Coin.COIN_500, coinMap.get(Coin.COIN_500) - 1);
//                    productPrice -= 500;
//                    if (productPrice == 0) break;
//                    continue;
//                }
//                if (productPrice >= 100 && coinMap.get(Coin.COIN_100) > 0) {
//                    coinMap.put(Coin.COIN_100, coinMap.get(Coin.COIN_100) - 1);
//                    productPrice -= 100;
//                    if (productPrice == 0) break;
//                    continue;
//                }
//                if (productPrice >= 50 && coinMap.get(Coin.COIN_50) > 0) {
//                    coinMap.put(Coin.COIN_50, coinMap.get(Coin.COIN_50) - 1);
//                    productPrice -= 50;
//                    if (productPrice == 0) break;
//                    continue;
//                }
//                if (productPrice >= 10 && coinMap.get(Coin.COIN_10) > 0) {
//                    coinMap.put(Coin.COIN_10, coinMap.get(Coin.COIN_10) - 1);
//                    productPrice -= 10;
//                    if (productPrice == 0) break;
//                }
//                if(coinMap.get(Coin.COIN_500) == 0 && coinMap.get(Coin.COIN_100) == 0 && coinMap.get(Coin.COIN_50) == 0 && coinMap.get(Coin.COIN_10) == 0) {
//                    break;
//                }
//            }
        }
        OutputView.printCurrentInputMoney(userMoneyInput);
        while (true) {
            if (userMoneyInput >= 500 && coinMap.get(Coin.COIN_500) > 0) {
                coinMap.put(Coin.COIN_500, coinMap.get(Coin.COIN_500) - 1);
                changeCoins.put(Coin.COIN_500, changeCoins.get(Coin.COIN_500) + 1);
                userMoneyInput -= 500;
                if (userMoneyInput == 0) break;
                continue;
            }
            if (userMoneyInput >= 100 && coinMap.get(Coin.COIN_100) > 0) {
                coinMap.put(Coin.COIN_100, coinMap.get(Coin.COIN_100) - 1);
                changeCoins.put(Coin.COIN_100, changeCoins.get(Coin.COIN_100) + 1);
                userMoneyInput -= 100;
                if (userMoneyInput == 0) break;
                continue;
            }
            if (userMoneyInput >= 50 && coinMap.get(Coin.COIN_50) > 0) {
                coinMap.put(Coin.COIN_50, coinMap.get(Coin.COIN_50) - 1);
                changeCoins.put(Coin.COIN_50, changeCoins.get(Coin.COIN_50) + 1);
                userMoneyInput -= 50;
                if (userMoneyInput == 0) break;
                continue;
            }
            if (userMoneyInput >= 10 && coinMap.get(Coin.COIN_10) > 0) {
                coinMap.put(Coin.COIN_10, coinMap.get(Coin.COIN_10) - 1);
                changeCoins.put(Coin.COIN_10, changeCoins.get(Coin.COIN_10) + 1);
                userMoneyInput -= 10;
                if (userMoneyInput == 0) break;
            }
            if(coinMap.get(Coin.COIN_500) == 0 && coinMap.get(Coin.COIN_100) == 0 && coinMap.get(Coin.COIN_50) == 0 && coinMap.get(Coin.COIN_10) == 0) {
                break;
            }
        }
//        for (Map.Entry<Coin, Integer> entry : changeCoins.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
        OutputView.printChange(changeCoins);
    }

    private static void setChangeMap(Map<Coin, Integer> coinsMap) {
        coinsMap.put(Coin.COIN_500, 0);
        coinsMap.put(Coin.COIN_100, 0);
        coinsMap.put(Coin.COIN_50, 0);
        coinsMap.put(Coin.COIN_10, 0);
    }
}
