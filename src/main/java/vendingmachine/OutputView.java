package vendingmachine;

import java.util.Map;

public class OutputView {
    public static final String VENDING_MACHINE_COIN_LIST = "\n자판기가 보유한 동전";
    public static final String FIVE_HUNDRED_COIN = "\n500원 - ";
    public static final String ONE_HUNDRED_COIN = "100원 - ";
    public static final String FIFTY_COIN = "50원 - ";
    public static final String TEN_COIN = "10원 - ";
    public static final String UNIT = "개";
    private static final String INPUT_MONEY = "\n투입 금액 :";
    public static final String CHANGE = "잔돈";
    public static final String WON = "개";

    public static void printFiveHundredRandomCoins(int randomCoin) {
        StringBuilder fiveHundredCoinList = new StringBuilder();
        fiveHundredCoinList.append(VENDING_MACHINE_COIN_LIST)
                .append(FIVE_HUNDRED_COIN).append(randomCoin).append(UNIT);
        System.out.println(fiveHundredCoinList);
    }

    public static void printOneHundredRandomCoins(int randomCoin) {
        StringBuilder oneHundredCoinList = new StringBuilder();
        oneHundredCoinList.append(ONE_HUNDRED_COIN).append(randomCoin).append(UNIT);
        System.out.println(oneHundredCoinList);
    }

    public static void printFiftyRandomCoins(int randomCoin) {
        StringBuilder fiftyCoinList = new StringBuilder();
        fiftyCoinList.append(FIFTY_COIN).append(randomCoin).append(UNIT);
        System.out.println(fiftyCoinList);
    }

    public static void printTenCoins(int randomCoin) {
        StringBuilder tenCoinList = new StringBuilder();
        tenCoinList.append(TEN_COIN).append(randomCoin).append(UNIT);
        System.out.println(tenCoinList);
    }

    public static void lastInputMoney(int inputMoney, Map<Integer, Integer> changes) {
        System.out.println(INPUT_MONEY + inputMoney + WON);
        System.out.println(CHANGE);

        for (int changeCoin:changes.keySet()) {
            System.out.println(changeCoin+"원 - "+changes.get(changeCoin));
        }

    }

}
