package vendingmachine.controller;

import vendingmachine.domain.Machine;
import vendingmachine.domain.Product;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class MachineController {

    private final Machine machine;
    private final InputView inputView;
    private final OutputView outputView;

    public MachineController() {

        this.inputView = new InputView();
        this.outputView = new OutputView();
        int machineCoin = repeat(inputView::inputMachineCoin);
        this.machine = new Machine(machineCoin);
        outputView.outputMachineChange(machine.getStoredChange());
    }

    public void play() {

        setProducts();
        setCash();

        while (!machine.isExhausted()) {
            outputView.outputRemainCoin(machine);
            repeat(() -> {
                String input = inputView.inputPurchase();
                machine.purchase(input);
                return null;
            });
        }

        outputView.outputRemainCoin(machine);
        outputView.outputResultChange(machine);
    }

    private void setCash() {
        int cash = repeat(inputView::inputCash);
        machine.addCash(cash);
    }

    private void setProducts() {
        List<Product> products = repeat(inputView::inputProduct);
        products.forEach(machine::addProduct);
    }

    private <T> T repeat(Supplier<T> inputMethod) {
        try {
            return inputMethod.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeat(inputMethod);
        }
    }
}
