package vendingmachine.controller;

import vendingmachine.Coin;
import vendingmachine.domain.consumer.Consumer;
import vendingmachine.domain.machine.VendingMachine;
import vendingmachine.util.IOProvider;

import java.util.EnumSet;

public class OrderController {
    private static Consumer consumer;
    private static VendingMachine vendingMachine;

    public static void init() {
        vendingMachine = VendingMachine.of(IOProvider.initVendingMachineBalance());
        vendingMachine.splitInfoAndFillProduct(IOProvider.readAllProductInfo());
        consumer = Consumer.from(IOProvider.initConsumerBalance());
    }

    public static void doShopping() {
        boolean keepShopping = true;

        while (keepShopping) {
            consumer.buy(vendingMachine.getProduct(IOProvider.readProductName()));
            keepShopping = vendingMachine.verifyConsumerCanBuyAnyProduct(consumer);
        }

        returnChange();
    }

    private static void returnChange() {
        EnumSet<Coin> coinEnumSet = EnumSet.of(Coin.COIN_10, Coin.COIN_50, Coin.COIN_100, Coin.COIN_500);
        vendingMachine.makeChange();
        coinEnumSet.stream()
                .filter((coin) -> coin.hasCountForChange())
                .forEach((coin) -> {
                    System.out.println("in");
                    IOProvider.printChangeEachCoin(coin);
                });
    }
}
