package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static String getVendingmachineAmount() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return readLine();
    }

    public static String getProducts() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        return readLine();
    }

    public static String getUserMoney() {
        System.out.println("투입 금액을 입력해 주세요.");
        return readLine();
    }

}
