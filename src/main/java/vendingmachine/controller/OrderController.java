package vendingmachine.controller;

import vendingmachine.domain.consumer.Consumer;
import vendingmachine.domain.machine.VendingMachine;
import vendingmachine.util.IOProvider;

public class OrderController {
    private Consumer consumer;
    private VendingMachine vendingMachine;

    public void init() {
        vendingMachine = VendingMachine.of(IOProvider.initVendingMachineBalance());
        vendingMachine.splitInfoAndFillProduct(IOProvider.readAllProductInfo());
        consumer = Consumer.from(IOProvider.initConsumerBalance());
    }

    public void doShopping() {
        boolean keepShopping = true;

        while (keepShopping) {
            consumer.buy(vendingMachine.getProduct(IOProvider.readProductName()));
            keepShopping = vendingMachine.verifyConsumerCanBuyAnyProduct(consumer);
        }
    }
}
