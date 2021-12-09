package vendingmachine;

import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.StringUtil;
import vendingmachine.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int initializeMoney = StringUtil.parseStringToInt(InputView.inputInitialAmount());
        VendingMachine vendingMachine = VendingMachine.makeVendingMachineHasMoney(initializeMoney);

    }
}
