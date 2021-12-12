package vendingmachine;

import java.util.List;

public class VendingMachineController {
    public static int vendingMachineMoney;
    public static int maxFiveHundredCoin;
    public static int maxOneHundredCoin;
    public static int maxFiftyCoin;
    public static int maxTenCoin;
    private static int fiveHundredRandomCoin;
    private static int oneHundredRandomCoin;
    private static int fiftyRandomCoin;
    private static int tenRandomCoin;

    public void run() {
        vendingMachineMoney = InputView.inputVendingMachineMoney();
        OutputView.printFiveHundredRandomCoins(createFiveHundredCoinRandomly(maxFiveHundredCoin));
        OutputView.printOneHundredRandomCoins(createOneHundredCoinRandomly(maxOneHundredCoin));
        OutputView.printFiftyRandomCoins(createFiftyCoinRandomly(maxFiftyCoin));
        OutputView.printTenRandomCoins(createTenCoinRandomly(maxTenCoin));
        InputView.inputProductInformation();
        InputView.inputMoney();
    }

    public static int createFiveHundredCoinRandomly(int maxFiveHundredCoin) {
        maxFiveHundredCoin = Coin.COIN_500.countMaxFiveHundredCoin(vendingMachineMoney);
        List<Integer> fiveHundredCoins = Coin.COIN_500.fiveHundredCoins(maxFiveHundredCoin);
        fiveHundredRandomCoin = Coin.COIN_500.createCoinRandom(fiveHundredCoins);
        return fiveHundredRandomCoin;
    }

    public static int createOneHundredCoinRandomly(int maxOneHundredCoin) {
        maxOneHundredCoin = Coin.COIN_100.countMaxOneHundredCoin(vendingMachineMoney - (fiveHundredRandomCoin * 500));
        List<Integer> oneHundredCoins = Coin.COIN_100.oneHundredCoins(maxOneHundredCoin);
        oneHundredRandomCoin = Coin.COIN_100.createCoinRandom(oneHundredCoins);
        return oneHundredRandomCoin;
    }

    public static int createFiftyCoinRandomly(int maxFiftyCoin) {
        maxFiftyCoin = Coin.COIN_50.countMaxFiftyCoin(vendingMachineMoney - (fiveHundredRandomCoin * 500) - (oneHundredRandomCoin * 100));
        List<Integer> fiftyCoins = Coin.COIN_50.fiftyCoins(maxFiftyCoin);
        fiftyRandomCoin = Coin.COIN_50.createCoinRandom(fiftyCoins);
        return fiftyRandomCoin;
    }

    public static int createTenCoinRandomly(int maxTenCoin) {
        maxTenCoin = Coin.COIN_10.countMaxTenCoin(vendingMachineMoney - (fiveHundredRandomCoin * 500) - (oneHundredRandomCoin * 100) - (fiftyRandomCoin * 50));
        List<Integer> tenCoins = Coin.COIN_10.tenCoins(maxTenCoin);
        tenRandomCoin = Coin.COIN_10.createCoinRandom(tenCoins);
        return tenRandomCoin;
    }
}
