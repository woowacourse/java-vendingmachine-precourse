package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.controller.VendingMachine;
import vendingmachine.io.ConsolePrinter;
import vendingmachine.io.ConsoleInput;

public class VendingMachineRunner {

    private final ConsolePrinter printer;
    private final ConsoleInput input;
    private VendingMachine vendingMachine;

    public VendingMachineRunner(ConsolePrinter printer, ConsoleInput input) {
        this.printer = printer;
        this.input = input;
    }

    public VendingMachineRunner() {
        this.printer = new ConsolePrinter(System.out);
        this.input = new ConsoleInput(Console::readLine);
    }

    public void run() {
        vendingMachine = new VendingMachine();
        fillHoldingAmount();
        fillProducts();
        insertMoney();
        order();
        printer.printChanges(vendingMachine.getChanges());
    }

    private void fillHoldingAmount() {
        vendingMachine.fillHoldingAmount(input.getValidHoldingAmount());
        printer.printHoldingAmount(vendingMachine.getHoldingAmount());
    }

    private void insertMoney() {
        vendingMachine.insertMoney(input.getValidInputAmount());
        printer.printInputAmount(vendingMachine.getCurrentInputAmount());
    }

    private void order() {
        try {
            vendingMachine.order(input.getProductOrder());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            order();
        }
        printer.printInputAmount(vendingMachine.getCurrentInputAmount());
        if (vendingMachine.isOrderAvailable()) {
            order();
        }
    }

    private void fillProducts() {
        vendingMachine.addProductSeller(input.getProductSeller());
    }
}
