package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputViews {
    public static String inputInitMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputProductList() {
        System.out.println("\n상품명과 가격, 수량을 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputUserMoney() {
        System.out.println("\n투입 금액을 입력해 주세요.");
        return Console.readLine();
    }
}
