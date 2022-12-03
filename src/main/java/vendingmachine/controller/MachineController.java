package vendingmachine.controller;

import vendingmachine.domain.Machine;
import vendingmachine.domain.Product;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;

public class MachineController {

    private final Machine machine;
    private final InputView inputView;
    private final OutputView outputView;

    public MachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        int machineCoin = inputView.inputMachineCoin();
        this.machine = new Machine(machineCoin);
        outputView.outputMachineChange(machine);
    }

    public void play() {
        List<Product> products = inputView.inputProduct();
        products.forEach(machine::storeProduct);

        int cache = inputView.inputCache();
        machine.storeCash(cache);

        while (!machine.isExhausted()) {
            outputView.outputRemainCoin(machine);
            inputView.inputPurchase(machine);
        }

        outputView.outputRemainCoin(machine);
        outputView.outputResultChange(machine);
    }
}
