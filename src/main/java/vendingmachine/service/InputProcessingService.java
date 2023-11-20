package vendingmachine.service;

import java.io.Console;
import java.util.function.Consumer;
import java.util.function.Supplier;
import vendingmachine.domain.Goods;
import vendingmachine.domain.VendingMachine;

public class InputProcessingService {
    public VendingMachine createVendingMachine(Supplier<String> inputSupplier, Runnable messagePrinter,
                                               Consumer<String> errorMessagePrinter) {
        while (true) {
            try {
                messagePrinter.run();
                String input = inputSupplier.get();
                return new VendingMachine(input);
            } catch (IllegalArgumentException e) {
                errorMessagePrinter.accept(e.getMessage());
            }
        }
    }

    public Goods createGoods(Supplier<String> inputSupplier, Runnable messagePrinter,
                             Consumer<String> errorMessagePrinter) {
        while (true) {
            try {
                messagePrinter.run();
                String input = inputSupplier.get();
                return new Goods(input);
            } catch (IllegalArgumentException e) {
                errorMessagePrinter.accept(e.getMessage());
            }
        }
    }

    public void inputCostumerMoney(VendingMachine vendingMachine, Supplier<String> inputSupplier,
                                   Runnable messagePrinter, Consumer<String> errorMessagePrinter) {
        while (true) {
            try {
                messagePrinter.run();
                String input = inputSupplier.get();
                vendingMachine.inputCustomerMoney(input);
                return;
            } catch (IllegalArgumentException e) {
                errorMessagePrinter.accept(e.getMessage());
            }
        }
    }
}
