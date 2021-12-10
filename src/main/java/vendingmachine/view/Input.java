package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String InputVendingMachineChange() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        return inputMoney;
    }

    public static String InputProductInfo() {
        System.out.println("\n상품명과 가격, 수량을 입력해 주세요.");
        String productInfo = Console.readLine();
        return productInfo;
    }

    public static String InputMoney() {
        System.out.println("\n투입 금액을 입력해주세요.");
        String money = Console.readLine();
        return money;
    }

    public static String InputPurchase(int money) {
        System.out.println("\n투입 금액: " + money + "원");
        System.out.println("구매할 상품명을 입력해 주세요.");
        String productName = Console.readLine();
        return productName;
    }
}
