package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.VendingMachineCoinValidator;

public class InputView {
    private static final String ASK_VENDING_MACHINE_AMOUNT = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    public long readVendingMachineAmount() {
        System.out.println(ASK_VENDING_MACHINE_AMOUNT);
        String input = Console.readLine();
        return VendingMachineCoinValidator.safeParseLong(input);
    }


}
