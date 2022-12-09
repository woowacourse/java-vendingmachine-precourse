package vendingmachine.view;

import vendingmachine.domain.Money;
import vendingmachine.domain.coins.Coin;
import vendingmachine.domain.coins.Coins;

import java.util.Map;

public class OutputView {

    private static final String MESSAGE_INPUT_VENDING_MACHINE_AMOUNT = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String MESSAGE_VENDING_MACHINE_COINS = "자판기가 보유한 동전";
    private static final String MESSAGE_COINS = "%d원 - %d개";
    private static final String MESSAGE_INPUT_PRODUCTS = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String MESSAGE_INPUT_MONEY = "투입 금액을 입력해 주세요.";
    private static final String MESSAGE_REMAIN_MONEY = "투입 금액: %d원";
    private static final String MESSAGE_INPUT_PRODUCT_NAME = "구매할 상품명을 입력해 주세요.";
    private static final String MESSAGE_CHANGES = "잔돈";

    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public void printInputVendingMachineAmount() {
        System.out.println(MESSAGE_INPUT_VENDING_MACHINE_AMOUNT);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printVendingMachineCoins(Coins coins) {
        System.out.println(MESSAGE_VENDING_MACHINE_COINS);
        printCoins(coins);
    }

    private void printCoins(Coins coins) {
        for (Map.Entry<Coin, Integer> coinEntry : coins.getCoins().entrySet()) {
            System.out.printf(MESSAGE_COINS, coinEntry.getKey().getAmount(), coinEntry.getValue());
            System.out.println();
        }
        System.out.println();
    }

    public void printInputProducts() {
        System.out.println(MESSAGE_INPUT_PRODUCTS);
    }

    public void printInputMoney() {
        System.out.println(MESSAGE_INPUT_MONEY);
    }

    public void printRemainMoney(Money money) {
        System.out.printf(MESSAGE_REMAIN_MONEY, money.getMoney());
        System.out.println();
    }

    public void printInputProductName() {
        System.out.println(MESSAGE_INPUT_PRODUCT_NAME);
    }

    public void printChanges(Coins coins) {
        System.out.println(MESSAGE_CHANGES);
        printCoins(coins);
    }
}
