package vendingmachine;

import java.util.Map;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.ValidationUtil;

public class View {
    public static void printVendingMachineCoin(Map<Coin, Integer> coins) {
        System.out.println();
        System.out.println("자판기가 보유한 동전");
        System.out.println("500원 - " + coins.getOrDefault(Coin.COIN_500, 0) + "개");
        System.out.println("100원 - " + coins.getOrDefault(Coin.COIN_100, 0) + "개");
        System.out.println("50원 - " + coins.getOrDefault(Coin.COIN_50, 0) + "개");
        System.out.println("10원 - " + coins.getOrDefault(Coin.COIN_10, 0) + "개");
    }

    public static void printCoins(InputAmount inputAmount, Map<Coin, Integer> coins) {
        System.out.println();
        System.out.println("투입 금액: " + inputAmount + "원");
        System.out.println("잔돈");
        coins.forEach((coin, count) -> System.out.println(coin.getAmount() + "원 - " + count + "개"));
    }

    public static String putCoinIntoVendingMachine() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String inputValue = Console.readLine().replace(" ", "");
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
        String value =  Console.readLine().replace(" ", "");
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
        String inputValue = Console.readLine().replace(" ", "");
        if (isValidAmount(inputValue)) {
            return inputValue;
        }
        return inputAmount();
    }

    public static String buyProduct(InputAmount userBalance) {
        System.out.println();
        System.out.println("투입 금액: " + userBalance + "원");
        System.out.println("구매할 상품명을 입력해 주세요.");
        String value = Console.readLine().replace(" ", "");
        if (isEmpty(value)) {
            return buyProduct(userBalance);
        }
        return value;
    }
}
