package vendingmachine.view;

import java.util.Map;
import vendingmachine.model.Budget;
import vendingmachine.model.Coin;
import vendingmachine.model.MachineMoney;

public class OutputView {

    private enum ConsoleMessage {
        OUTPUT_MACHINE_MONEY("자판기가 보유한 동전"),
        OUTPUT_MACHINE_MONEY_FORMAT("%d원 - %d개%n"),
        OUTPUT_LEFT_MONEY("투입 금액: %d원%n");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printMachineMoney(MachineMoney machineMoney) {
        System.out.println(ConsoleMessage.OUTPUT_MACHINE_MONEY.message);
        for (Map.Entry<Coin, Integer> element : machineMoney.getMachineMoney().entrySet()) {
            System.out.printf(ConsoleMessage.OUTPUT_MACHINE_MONEY_FORMAT.message,
                    element.getKey().getAmount(), element.getValue());
        }
    }

    public void printLeftMoney(Budget budget) {
        System.out.printf(ConsoleMessage.OUTPUT_LEFT_MONEY.message, budget.getLeftMoney());
    }
}
