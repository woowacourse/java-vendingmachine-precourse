package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import static validator.InputNumberValidator.validateVendingMachineMoney;

public class InputView {
    public static int inputVendingMachineMoney() {
        try {
            System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
            return validateVendingMachineMoney(Console.readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputVendingMachineMoney();
        }
    }

    public static String inputProductInformation() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputMoney() {
        System.out.println("투입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputProductToBuy() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        return Console.readLine();
    }
}