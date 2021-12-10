package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int InputVendingMachineChange(){
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        return Integer.parseInt(inputMoney);
    }

    public static String InputProductInfo(){
        System.out.println("\n상품명과 가격, 수량을 입력해 주세요.");
        String productInfo = Console.readLine();
        return productInfo;
    }
}
