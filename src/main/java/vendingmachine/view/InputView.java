package vendingmachine.view;

import static vendingmachine.Messages.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    //자판기 보유 금액 입력
    public int inputVendingMachineCoin() {
        System.out.println(INPUT_VENDING_MACHINE_COIN);
        String vendingMachineCoin = Console.readLine();
        validateVendingMachineCoin(vendingMachineCoin);
        return Integer.parseInt(vendingMachineCoin);
    }

    //자판기 보유 금액 문자일 경우 예외 처리
    private void validateVendingMachineCoin(String vendingMachineCoin) {
        if (!vendingMachineCoin.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(ERROR_INPUT_VENDING_MACHINE_COIN);
        }
    }

    //자판기 상품 목록 입력
    public String inputProducts() {
        System.out.println(INPUT_PRODUCTS);
        return Console.readLine();
    }

    //사용자 금액 입력
    public int inputMoney() {
        System.out.println(INPUT_MONEY);
        String money = Console.readLine();
        validateMoney(money);
        return Integer.parseInt(money);
    }

    //사용자 금액 문자일 경우 예외 처리
    private void validateMoney(String money) {
        if (money.matches("^[0-9]$")) {
            throw new IllegalArgumentException(ERROR_INPUT_MONEY);
        }
    }

    //구매할 상품명 입력
    public String inputProductName() {
        System.out.println(INPUT_PRODUCT_NAME);
        return Console.readLine();
    }
}