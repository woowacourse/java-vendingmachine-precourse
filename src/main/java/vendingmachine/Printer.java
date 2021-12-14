package vendingmachine;

import static vendingmachine.InfoMessage.CUSTOMER_MONEY_INPUT_MESSAGE;
import static vendingmachine.InfoMessage.CUSTOMER_PURCHASE_INPUT_MESSAGE;
import static vendingmachine.InfoMessage.MACHINE_MONEY_INPUT_MESSAGE;
import static vendingmachine.InfoMessage.MACHINE_PRODUCT_INPUT_MESSAGE;

import java.util.Map;

public class Printer {

    public void printMachineMoneyInputMessage() {
        System.out.println(MACHINE_MONEY_INPUT_MESSAGE.getMessage());
    }

    public void printProductInfoInputMessage() {
        System.out.println(MACHINE_PRODUCT_INPUT_MESSAGE.getMessage());
    }

    public void printCustomerMoneyInputMessage() {
        System.out.println(System.lineSeparator() + CUSTOMER_MONEY_INPUT_MESSAGE.getMessage());
    }

    public void printPurchaseProductInputMessage() {
        System.out.println(CUSTOMER_PURCHASE_INPUT_MESSAGE.getMessage());
    }

    public void printCustomerMoney(int money) {
        System.out.printf(System.lineSeparator() + "투입 금액: %d원%n", money);
    }

    public void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printMachineCoins(Map<Coin, Integer> coins) {
        System.out.println(System.lineSeparator() + "자판기가 보유한 동전");
        printCoinQuantity(coins);
    }

    public void printChanges(Map<Coin, Integer> coins) {
        System.out.println(System.lineSeparator() + "잔돈");
        printCoinQuantity(coins);
    }

    private void printCoinQuantity(Map<Coin, Integer> coins) {
        for (Coin coin : coins.keySet()) {
            System.out.printf("%d원 - %d개%n", coin.getAmount(), coins.get(coin));
        }
        System.out.println();
    }
}
