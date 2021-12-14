package vendingmachine;


import static vendingmachine.view.Output.*;

import vendingmachine.coin.Coin;
import vendingmachine.machine.Machine;
import vendingmachine.machine.MachineController;
import vendingmachine.view.Input;
import vendingmachine.view.Output;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
       MachineController machineController = new MachineController();
       Input input = new Input();
       Output output = new Output();
       Machine machine = new Machine();
       machineController.start(machine,input.inputMoney(),input.inputProducts());
       // machine.getCoins().forEach((coin, integer) -> {
       //     System.out.println(coin.getAmount());
       //     System.out.println(integer);
       // });

        output.printCoins(machine);




    }
}
