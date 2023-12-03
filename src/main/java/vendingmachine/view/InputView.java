package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.VendingMachine.VendingMachine;
import vendingmachine.service.VendingMachine.VendingMachineService;

public class InputView {

    public static VendingMachine getVendingMachine() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return VendingMachineService.getVendingMachine(Console.readLine());
    }

}
