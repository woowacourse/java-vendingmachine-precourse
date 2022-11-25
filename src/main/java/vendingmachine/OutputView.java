package vendingmachine;

import static vendingmachine.MessageUtils.INPUT_MACHINE_MONEY;
import static vendingmachine.MessageUtils.INPUT_MERCHANDISE_INFO;
import static vendingmachine.MessageUtils.MACHINE_COIN_INFO;

import java.util.EnumMap;

public class OutputView {
    private static final String WON = "원";
    private static final String AMT = "개";

    private static final String DELIMITER = " - ";

    private static final String ERROR = "[ERROR]";

    public void printErrorMessage(String errorMsg){
        System.out.println(ERROR + " " + errorMsg);
    }

    public void printMachineMoneyInputOpening(){
        System.out.println(INPUT_MACHINE_MONEY.msg());
    }

    public void printMachineCoinInfo(RemainingCoins remainingCoins) {
        System.out.println();
        System.out.println(MACHINE_COIN_INFO.msg());
        EnumMap<Coin, Integer> coinMap = remainingCoins.getRemainingCoins();
        for (Coin coin : coinMap.keySet()) {
            System.out.println(coin.amount() + WON + DELIMITER + coinMap.get(coin) + AMT);
        }
    }

    public void printMerchandiseInfoOpening(){
        System.out.println(INPUT_MERCHANDISE_INFO.msg());
    }
}
