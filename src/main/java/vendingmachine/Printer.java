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

    public void printProductInfosInputMessage() {
        System.out.println(MACHINE_PRODUCT_INPUT_MESSAGE.getMessage());
    }

    public void printCustomerMoneyInputMessage() {
        System.out.println();
        System.out.println(CUSTOMER_MONEY_INPUT_MESSAGE.getMessage());
    }

    public void printPurchaseProductInputMessage() {
        System.out.println(CUSTOMER_PURCHASE_INPUT_MESSAGE.getMessage());
    }

    public void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printMachineCoins(Map<Coin, Integer> coins) {
        System.out.println();
        System.out.println("자판기가 보유한 동전");
        printCoinCount(coins);
    }

    public void printChanges(Map<Coin, Integer> coins) {
        System.out.println("잔돈");
        printCoinCount(coins);
    }

    public void printCustomerMoney(int money) {
        System.out.println();
        System.out.printf("투입 금액: %d원%n", money);
    }

    private void printCoinCount(Map<Coin, Integer> coins) {
        for (Coin coin : coins.keySet()) {
            System.out.println(coin.getAmount() + "원 - " + coins.get(coin) + "개");
        }
        System.out.println();
    }
}
