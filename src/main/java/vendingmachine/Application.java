package vendingmachine;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Converter converter = new Converter();
        Printer printer = new Printer();
        Input input = new Input();

        printer.printMachineMoneyInputMessage();
        int machineMoney = input.inputMoney();
        Map<Coin, Integer> machineCoins = converter.convertToCoins(machineMoney);
        printer.printMachineCoins(machineCoins);

        printer.printProductInfoInputMessage();
        String productInfos = input.inputProductInfos();
        List<Product> products = converter.convertToProducts(productInfos);

        VendingMachine vendingMachine = new VendingMachine(machineCoins, products);
        vendingMachine.run();
    }
}
