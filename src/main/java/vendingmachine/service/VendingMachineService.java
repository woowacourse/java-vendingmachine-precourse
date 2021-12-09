package vendingmachine.service;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;

public class VendingMachineService {

    private final InputView inputView;
    private final OutputView outputView;

    public VendingMachineService(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String inputMachineHaveMoney() {
        inputView.printInputMachineHaveMoney();

        return inputValue();
    }

    public String inputValue() {
        return Console.readLine();
    }

}
