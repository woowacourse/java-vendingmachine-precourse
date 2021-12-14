package vendingmachine.controller;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.util.CoinRandomProvider;
import vendingmachine.domain.consumer.Consumer;
import vendingmachine.domain.machine.VendingMachine;
import vendingmachine.util.IOProvider;

import java.util.EnumSet;

public class OrderController {
    private static Consumer consumer;
    private static VendingMachine vendingMachine;

    private static EnumSet<Coin> coinEnumSet = EnumSet.of(Coin.COIN_10, Coin.COIN_50, Coin.COIN_100, Coin.COIN_500);

    public static void init() {
        inputVendingMachine();
        inputProductsInfo();
        inputConsumerBalance();
        }

    private static void inputVendingMachine() {
        vendingMachine = VendingMachine.of(IOProvider.initVendingMachineBalance());
        vendingMachine.fillCoinsAsBalanceAmount(new CoinRandomProvider());
        IOProvider.addNewLine();

        IOProvider.printMessage("자판기가 보유한 동전");
        coinEnumSet.stream()
                .forEach((coin) -> {
                    IOProvider.printVendingMachineCoins(coin);
                });
        IOProvider.addNewLine();
    }

    private static void inputProductsInfo() {

        vendingMachine.splitInfoAndFillProduct(IOProvider.readAllProductInfo());
        IOProvider.addNewLine();
    }

    private static void inputConsumerBalance() {
        consumer = Consumer.from(IOProvider.initConsumerBalance());
        IOProvider.addNewLine();
    }

    public static void doShopping() {
        boolean keepShopping = true;

        while (keepShopping) {
            IOProvider.printMessage(consumer.getCurrentBalanceMessage());

            consumer.buy(vendingMachine.getProduct(IOProvider.readProductName()));
            keepShopping = vendingMachine.verifyConsumerCanBuyAnyProduct(consumer);

            IOProvider.addNewLine();
        }

        returnChange();
    }

    private static void returnChange() {
        vendingMachine.makeChange(vendingMachine.returnChangeAmount(consumer));

        IOProvider.printMessage(consumer.getCurrentBalanceMessage());

        IOProvider.printMessage("잔돈");

        coinEnumSet.stream()
                .filter((coin) -> coin.hasCountForChange())
                .forEach((coin) -> {
                    IOProvider.printChangeEachCoin(coin);
                });
    }
}
