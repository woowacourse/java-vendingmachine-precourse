package view;

import java.util.Map;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Coin;
import vendingmachine.utils.ValidationUtil;

public class View {
    public static final int DEFAULT_VALUE = 0;
    public static final String TARGET_SPACE = " ";
    public static final String REPLACEMENT_EMPTY = "";

    public static void printInitialCoins(Map<Coin, Integer> coins) {
        System.out.println();
        System.out.println("자판기가 보유한 동전");
        System.out.println("500원 - " + coins.getOrDefault(Coin.COIN_500, DEFAULT_VALUE) + "개");
        System.out.println("100원 - " + coins.getOrDefault(Coin.COIN_100, DEFAULT_VALUE) + "개");
        System.out.println("50원 - " + coins.getOrDefault(Coin.COIN_50, DEFAULT_VALUE) + "개");
        System.out.println("10원 - " + coins.getOrDefault(Coin.COIN_10, DEFAULT_VALUE) + "개");
    }

    public static void printCoins(int inputAmount, Map<Coin, Integer> coins) {
        System.out.println();
        System.out.println("투입 금액: " + inputAmount + "원");
        System.out.println("잔돈");
        coins.forEach((coin, count) -> System.out.println(coin.getAmount() + "원 - " + count + "개"));
    }

    public static String putCoinIntoVendingMachine() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String inputValue = Console.readLine().replace(TARGET_SPACE, REPLACEMENT_EMPTY);
        if (isValidAmount(inputValue)) {
            return inputValue;
        }
        return putCoinIntoVendingMachine();
    }

    private static boolean isValidAmount(String inputValue) {
        try {
            ValidationUtil.checkAmount(inputValue);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static String registerProduct() {
        System.out.println();
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String value =  Console.readLine().replace(TARGET_SPACE, REPLACEMENT_EMPTY);
        if (isEmpty(value)) {
            return registerProduct();
        }
        return value;
    }

    private static boolean isEmpty(String value) {
        try {
            ValidationUtil.checkIsEmpty(value);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public static String inputAmount() {
        System.out.println();
        System.out.println("투입 금액을 입력해 주세요.");
        String inputValue = Console.readLine().replace(TARGET_SPACE, REPLACEMENT_EMPTY);
        if (isValidAmount(inputValue)) {
            return inputValue;
        }
        return inputAmount();
    }

    public static String buyProduct(int userBalance) {
        System.out.println();
        System.out.println("투입 금액: " + userBalance + "원");
        System.out.println("구매할 상품명을 입력해 주세요.");
        String value = Console.readLine().replace(TARGET_SPACE, REPLACEMENT_EMPTY);
        if (isEmpty(value)) {
            return buyProduct(userBalance);
        }
        return value;
    }
}
