package vendingmachine.util;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Coin;

public class IOProvider {
    private static final String ASK_MACHINE_BALANCE_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String ASK_ALL_PRODUCT_INFO_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String ASK_CONSUMER_BALANCE_MESSAGE = "투입 금액을 입력해 주세요.";
    private static final String ASK_PRODUCT_NAME_MESSAGE = "구매할 상품명을 입력해 주세요.";

    public static int initVendingMachineBalance() {
        print(ASK_MACHINE_BALANCE_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public static String readAllProductInfo() {
        print(ASK_ALL_PRODUCT_INFO_MESSAGE);
        return Console.readLine();
    }

    public static int initConsumerBalance() {
        print(ASK_CONSUMER_BALANCE_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    private static void print(String message) {
        System.out.println(message);
    }

    public static String readProductName() {
        print(ASK_PRODUCT_NAME_MESSAGE);
        return Console.readLine();
    }

    public static void printChangeEachCoin(Coin coin) {
        System.out.println(coin.getCountForChangeMessage());
    }
}
