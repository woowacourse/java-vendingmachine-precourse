package vendingmachine;

import vendingmachine.domain.Coin;
import vendingmachine.domain.CoinCount;

import java.util.Arrays;
import java.util.Map;

public class OutputView {
    private static final String VENDING_MACHINE_OF_COIN_INSTRUCTION = "자판기가 보유한 동전 ";
    private static final String MONEY_TO_COUNT_MAPPER = " - ";
    private static final String UNIT_OF_COIN_COUNT = "개 ";
    private static final String UNIT_OF_COIN = "원 ";
    private static final String INPUT_MONEY_OF_VENDING_MACHINE_INSTRUCTION = "투입 금액: ";



    public void printVeningMachineCoin(CoinCount coinCount) {
        System.out.println(VENDING_MACHINE_OF_COIN_INSTRUCTION);
        coinCount.getCoinCount().forEach((key, value) -> {
            System.out.println(key.getAmount() + UNIT_OF_COIN + MONEY_TO_COUNT_MAPPER + value + UNIT_OF_COIN_COUNT);
        });
        System.out.println();
    }

    public void printMoneyInputToVendingMachine(int inputMoney) {
        System.out.println();
        System.out.println(INPUT_MONEY_OF_VENDING_MACHINE_INSTRUCTION + inputMoney);
    }

}
