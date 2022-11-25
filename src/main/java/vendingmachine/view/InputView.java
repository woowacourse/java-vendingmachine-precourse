package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private int vendingMachineCoin;

    public int inputVendingMachineCoinProcess() {
        try {
            vendingMachineCoin = inputVendingMachineCoin();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputVendingMachineCoinProcess();
        }
        return vendingMachineCoin;
    }

    private int inputVendingMachineCoin() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String vendingMachineCoin = Console.readLine();
        validateVendingMachineCoin(vendingMachineCoin);
        return Integer.parseInt(vendingMachineCoin);
    }

    private void validateVendingMachineCoin(String vendingMachineCoin) {
        if (!vendingMachineCoin.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
