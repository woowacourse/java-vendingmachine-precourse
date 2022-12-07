package vendingmachine.view;

import java.util.Iterator;
import java.util.Map;
import vendingmachine.model.Coin;
import vendingmachine.model.MachineMoney;

public class OutputView {

    private enum ConsoleMessage {
        INPUT_BUDGET("구입금액을 입력해 주세요.");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printMachineMoney(MachineMoney machineMoney) {
        for (Map.Entry<Coin, Integer> element : machineMoney.getMachineMoney().entrySet()) {
            System.out.println(String.format("%d원 - %d개", element.getKey().getAmount(), element.getValue()));
        }
    }

}
