package vendingmachine.view;

import vendingmachine.domain.coins.Coin;
import vendingmachine.domain.coins.Coins;

import java.util.Map;

public class OutputView {

    private static final String MESSAGE_INPUT_VENDING_MACHINE_AMOUNT = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String MESSAGE_COINS = "%d원 - %d개";
    private static final String MESSAGE_INPUT_PRODUCTS = "상품명과 가격, 수량을 입력해 주세요.";

    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public void printInputVendingMachineAmount() {
        System.out.println(MESSAGE_INPUT_VENDING_MACHINE_AMOUNT);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printCoins(Coins coins) {
        for (Map.Entry<Coin, Integer> coinEntry : coins.getCoins().entrySet()) {
            System.out.printf(MESSAGE_COINS, coinEntry.getKey().getAmount(), coinEntry.getValue());
            System.out.println();
        }
        System.out.println();
    }

    public void printInputProducts() {
        System.out.println(MESSAGE_INPUT_PRODUCTS);
    }
}
