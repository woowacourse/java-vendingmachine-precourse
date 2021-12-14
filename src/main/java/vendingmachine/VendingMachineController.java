package vendingmachine;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineController {
    public static int vendingMachineMoney;
    public static int maxFiveHundredCoin;
    public static int maxOneHundredCoin;
    public static int maxFiftyCoin;
    public static int maxTenCoin;
    private static int fiveHundredRandomCoin;
    private static int oneHundredRandomCoin;
    private static int fiftyRandomCoin;

    private final Change change = new Change();

    public void run() {
        vendingMachineMoney = InputView.inputVendingMachineMoney();

        Map<String, Integer> coins = getRandomCoins();

        String inputProductList = InputView.inputProductInformation();
        List<Product> productList = ProductFunction.createProduct(inputProductList);

        int inputMoney = InputView.inputMoney();

        do {
            String inputProductName = InputView.inputProductToBuy(inputMoney);
            inputMoney = purchaseProduct(inputProductName, productList, inputMoney);
        } while (stopPurchasing(inputMoney, productList));

        Map<Integer, Integer> changes = change.getChanges(coins, inputMoney);
        OutputView.lastInputMoney(inputMoney, changes);

    }

    private Map<String, Integer> getRandomCoins() {
        int restMoney = vendingMachineMoney;
        int fiveHundredCoin = 0;
        int oneHundredCoin = 0;
        int fiftyCoin = 0;
        int tenCoin = 0;

        while (restMoney != 0) {
            int coin = selectCoin(restMoney);
            restMoney -= coin;
            if (coin == 500) {
                fiveHundredCoin++;
            }
            if (coin == 100) {
                oneHundredCoin++;
            }
            if (coin == 50) {
                fiftyCoin++;
            }
            if (coin == 10) {
                tenCoin++;
            }
        }


        OutputView.printFiveHundredRandomCoins(fiveHundredCoin);
        OutputView.printOneHundredRandomCoins(oneHundredCoin);
        OutputView.printFiftyRandomCoins(fiftyCoin);
        OutputView.printTenCoins(tenCoin);

        return getCoins(fiveHundredCoin, oneHundredCoin, fiftyCoin, tenCoin);
    }

    private int selectCoin(int restMoney) {
        return Coin.COIN_500.createCoinRandom(Coin.COIN_500.generateCoins(restMoney));
    }

    private Map<String, Integer> getCoins(int fiveHundredCoin, int oneHundredCoin, int fiftyCoin, int tenCoin) {
        Map<String, Integer> coins = new LinkedHashMap<>();
        coins.put("Coin_" + Coin.COIN_500.getAmount(), fiveHundredCoin);
        coins.put("Coin_" + Coin.COIN_100.getAmount(), oneHundredCoin);
        coins.put("Coin_" + Coin.COIN_50.getAmount(), fiftyCoin);
        coins.put("Coin_" + Coin.COIN_10.getAmount(), tenCoin);
        return coins;
    }

    private int findMinimumPrice(List<Product> productList) {
        int minimumPrice = productList.get(0).getPrice();

        for (Product product : productList) {
            if (minimumPrice > product.getPrice()) {
                minimumPrice = product.getPrice();
            }
        }

        return minimumPrice;
    }

    private boolean stopPurchasing(int inputMoney, List<Product> productList) {
        int minimumPrice = findMinimumPrice(productList);
        boolean isStopPurchasing = true;

        if (inputMoney <= 0) {
            isStopPurchasing = false;
        }

        if (inputMoney < minimumPrice) {
            isStopPurchasing = false;
        }

        if (allSell(productList)) {
            isStopPurchasing = false;
        }


        return isStopPurchasing;
    }

    private boolean allSell(List<Product> productList) {
        boolean isAllSell = true;

        for (Product product : productList) {
            if (product.getCount() != 0) {
                isAllSell = false;
                break;
            }
        }

        return isAllSell;
    }

    private int purchaseProduct(String inputProductName, List<Product> productList, int inputMoney) {

        for (Product product : productList) {
            if (product.getProductName().equals(inputProductName)) {
                inputMoney = product.sell(inputMoney);
            }
        }

        return inputMoney;
    }
}
