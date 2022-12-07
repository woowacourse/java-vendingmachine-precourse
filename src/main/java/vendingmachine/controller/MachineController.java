package vendingmachine.controller;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private final InputView inputView;
    private final OutputView outputView;

    public MachineController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        try {
            int machineMoney = inputView.readMachineMoney();
            System.out.println(machineMoney);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }
}