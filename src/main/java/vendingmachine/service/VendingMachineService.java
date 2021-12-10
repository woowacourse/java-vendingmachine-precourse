package vendingmachine.service;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;
import vendingmachine.domain.VendingMachine;

public class VendingMachineService {

    private final InputView inputView;
    private final OutputView outputView;

    public VendingMachineService(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public VendingMachine createVendingMachine() {
        try {
            inputView.printInputMachineHaveMoney();
            String inputMachineHaveMoney = inputValue();

            return new VendingMachine(inputMachineHaveMoney);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException);

            return createVendingMachine();
        }
    }

    public String inputValue() {
        return Console.readLine();
    }

}
