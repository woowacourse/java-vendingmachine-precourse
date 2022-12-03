package vendingmachine.view;

import vendingmachine.Coin;
import vendingmachine.domain.Machine;

import java.util.Map;

import static vendingmachine.utils.Message.OUTPUT_CASH;
import static vendingmachine.utils.Message.OUTPUT_INIT_EXCHANGE;

public class OutputView {

    public void outputMachineExchange(Machine machine) {
        Map<Coin, Integer> currentExchange = machine.getCurrentExchange();
        System.out.println(OUTPUT_INIT_EXCHANGE);
        for (Map.Entry<Coin, Integer> entry : currentExchange.entrySet()) {
            Coin key = entry.getKey();
            Integer count = entry.getValue();
            System.out.printf("%d원 - %d개\n", key.getAmount(), count);
        }
    }

    public void outputRemainCoin(Machine machine) {
        System.out.printf("%s %d원\n", OUTPUT_CASH, machine.getRemainCoin());
    }

    public void outputResultExchange(Machine machine) {
        Map<Coin, Integer> exchangeResult = machine.getExchangeResult();

        for (Map.Entry<Coin, Integer> entry : exchangeResult.entrySet()) {
            Coin key = entry.getKey();
            Integer count = entry.getValue();
            if (count != 0) {
                System.out.printf("%d원 - %d개\n", key.getAmount(), count);
            }
        }
    }
}
