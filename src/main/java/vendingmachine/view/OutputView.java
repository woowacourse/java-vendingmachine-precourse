package vendingmachine.view;

import vendingmachine.domain.Coin;

import java.util.Map;

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

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage + LINE_BREAK);
    }

    public static void printBalanceCoins(Map<Coin, Integer> balanceCoin) {
        System.out.println(VENDING_MACHINE_BALANCE);

        for (Coin coin : balanceCoin.keySet()) {
            System.out.println(coin.getAmount() + WON + HYPHEN + balanceCoin.get(coin) + NUMBER_OF);
        }

        System.out.println();
    }
}
