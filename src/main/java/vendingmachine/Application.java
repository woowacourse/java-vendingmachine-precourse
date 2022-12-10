package vendingmachine;

import vendingmachine.controller.MachineController;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Machine;
import vendingmachine.domain.Product;
import vendingmachine.view.OutputView;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Product product = new Product("콜라",2000,20);
        Machine machine = new Machine(product);
        LinkedHashMap<Coin, Integer> coinMap = machine.getCoins();
        OutputView.printMachineInputMoneyMsg();
        OutputView.printMachineHasCoins(coinMap);

    }
}
