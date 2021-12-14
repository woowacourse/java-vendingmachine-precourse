package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coin;

public class OutputView {
    public static final String LINE_BREAK = "\n";
    public static final String REQUEST_VENDING_MACHINE_BALANCE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String VENDING_MACHINE_BALANCE = LINE_BREAK + "자판기가 보유한 동전";
    public static final String WON = "원";
    public static final String HYPHEN = " - ";
    public static final String NUMBER_OF = "개";
    public static final String REQUEST_ITEM_INFORMATION = "상품명과 가격, 수량을 입력해 주세요.";
    public static final String REQUEST_INSERT_MONEY = LINE_BREAK + "투입 금액을 입력해 주세요.";
    public static final String REQUEST_PURCHASE_ITEM = "구매할 상품명을 입력해 주세요.";
    public static final String INSERT_MONEY = LINE_BREAK + "투입 금액: ";
    public static final String CHANGE = "잔돈";

    public static void requestVendingMachineBalance() {
        System.out.println(REQUEST_VENDING_MACHINE_BALANCE);
    }

    public static void requestItemInformation() {
        System.out.println(REQUEST_ITEM_INFORMATION);
    }

    public static void requestInsertMoney() {
        System.out.println(REQUEST_INSERT_MONEY);
    }

    public static void requestPurchaseItem() {
        System.out.println(REQUEST_PURCHASE_ITEM);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage + LINE_BREAK);
    }

    public static void printBalanceCoins(Map<Coin, Integer> balanceCoin) {
        System.out.println(VENDING_MACHINE_BALANCE);
        balanceCoin.forEach((coin, count) -> System.out.println(coin.getAmount() + WON + HYPHEN + count + NUMBER_OF));
        System.out.println();
    }

    public static void printChangeCoins(int money, Map<Coin, Integer> changeCoin) {
        printRemainMoney(money);
        System.out.println(CHANGE);
        changeCoin.forEach((coin, count) -> System.out.println(coin.getAmount() + WON + HYPHEN + count + NUMBER_OF));

    }

    public static void printRemainMoney(int money) {
        System.out.println(INSERT_MONEY + money + WON);
    }
}
