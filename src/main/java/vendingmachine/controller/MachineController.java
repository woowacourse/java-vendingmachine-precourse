package vendingmachine.controller;

import vendingmachine.model.MachineMoney;
import vendingmachine.model.Products;
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
            // 자판기가 보유하고 있는 금액 설정
            MachineMoney machineMoney = MachineMoney.from(inputView.readMachineMoney());
            outputView.printMachineMoney(machineMoney);

            // 자판기의 상품 설정
            Products products = Products.from(inputView.readProducts());

        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }
}