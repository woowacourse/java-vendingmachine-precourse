package vendingmachine.machine;

import camp.nextstep.edu.missionutils.Console;

public class MachineView {
    private static final String INPUT_MONEY_MESSAGE = "투입 금액을 입력해 주세요.";
    private static final String INPUT_ITEM_MESSAGE = "구매할 상품명을 입력해 주세요.";


    public static String inputMoney() {
        System.out.println();
        System.out.println(INPUT_MONEY_MESSAGE);
        String money = Console.readLine();
        System.out.println();
        return money;
    }


    public static String inputItem() {
        System.out.println(INPUT_ITEM_MESSAGE);
        String product = Console.readLine();
        System.out.println();
        return product;
    }
}
