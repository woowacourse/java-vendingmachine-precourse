package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputHowMuch() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static void countCoin() {
        int Bill = Integer.parseInt(inputHowMuch());
        System.out.println("\n자판기가 보유한 동전");
        System.out.println("500원 - " + (Bill / 500) + "개");
        System.out.println("100원 - " + ((Bill / 500) / 100) + "개");
        System.out.println("50원 - " + (((Bill / 500) / 100) / 50) + "개");
        System.out.println("10원 - " + ((((Bill / 500) / 100) / 50) / 10) + "개");
    }

    public static String inputProductInformation() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputBill() {
        System.out.println("투입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputProductToBuy() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        return Console.readLine();
    }
}
