package vendingmachine.view;

import vendingmachine.Coin;
import vendingmachine.domain.Machine;

import java.util.Map;

import static vendingmachine.utils.Message.OUTPUT_CASH;
import static vendingmachine.utils.Message.OUTPUT_INIT_CHANGE;

public class OutputView {

    public void outputMachineChange(Machine machine) {
        Map<Coin, Integer> currentChange = machine.getStoredChange();
        System.out.println(OUTPUT_INIT_CHANGE);
        for (Map.Entry<Coin, Integer> entry : currentChange.entrySet()) {
            Coin key = entry.getKey();
            Integer count = entry.getValue();
            System.out.printf("%d원 - %d개\n", key.getAmount(), count);
        }
    }

    public void outputRemainCoin(Machine machine) {
        System.out.printf("%s %d원\n", OUTPUT_CASH, machine.getStoredCash());
    }

    public void outputResultChange(Machine machine) {
        Map<Coin, Integer> changeResult = machine.getReturnChange();

        for (Map.Entry<Coin, Integer> entry : changeResult.entrySet()) {
            Coin key = entry.getKey();
            Integer count = entry.getValue();
            if (count != 0) {
                System.out.printf("%d원 - %d개\n", key.getAmount(), count);
            }
        }
    }
}
