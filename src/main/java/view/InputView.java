package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_VENDING_MACHINE_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_PRODUCT_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_INSERT_MESSAGE = "투입 금액을 입력해 주세요.";
    public String inputVendingMachineMoney(){
        System.out.println(INPUT_VENDING_MACHINE_MONEY_MESSAGE);
        return Console.readLine().trim();
    }

    public String inputProduct(){
        System.out.println("\n"+INPUT_PRODUCT_MESSAGE);
        return Console.readLine().trim();
    }

    public String inputInsertMoney(){
        System.out.println("\n"+INPUT_INSERT_MESSAGE);
        return Console.readLine();
    }
}
