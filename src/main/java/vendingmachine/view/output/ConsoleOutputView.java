package vendingmachine.view.output;

import java.util.Map;

public class ConsoleOutputView implements OutputView {
    private static final String INPUT_MONEY_MESSAGE = "투입 금액: ";
    private static final String VENDING_MACHINE_OWNING_COINS_MESSAGE = "자판기가 보유한 동전";
    private static final String MONETARY_UNIT = "원";
    private static final String CHANGE_WORDS = "잔돈";
    private static final String DELIMITER_OF_COIN_AND_NUMBER = " - ";
    private static final String COUNT_UNIT = "개";

    @Override
    public void showRemainingInputMoney(int remainingInputMoney) {
        System.out.println(INPUT_MONEY_MESSAGE + remainingInputMoney + MONETARY_UNIT);
    }

    @Override
    public void showVendingMachineOwningCoins(final Map<Integer, Integer> kindOfCoinAndNumberOfCoins) {
        System.out.println(VENDING_MACHINE_OWNING_COINS_MESSAGE);
        kindOfCoinAndNumberOfCoins.keySet()
                .forEach(coin -> System.out.println(coin + MONETARY_UNIT
                        + DELIMITER_OF_COIN_AND_NUMBER + kindOfCoinAndNumberOfCoins.get(coin) + COUNT_UNIT));
        System.out.println();
    }

    @Override
    public void showChanges(final Map<Integer, Integer> kindOfCoinAndNumberOfCoins) {
        System.out.println(CHANGE_WORDS);
        kindOfCoinAndNumberOfCoins.keySet()
                .forEach(coin -> System.out.println(coin + MONETARY_UNIT
                        + DELIMITER_OF_COIN_AND_NUMBER + kindOfCoinAndNumberOfCoins.get(coin) + COUNT_UNIT));

    }
}
