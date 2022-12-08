package vendingmachine.view;

import java.util.Map;
import vendingmachine.model.Budget;
import vendingmachine.model.Coin;
import vendingmachine.model.MachineMoney;

public class OutputView {

    private enum ConsoleMessage {
        OUTPUT_MACHINE_MONEY("자판기가 보유한 동전"),
        OUTPUT_MACHINE_MONEY_FORMAT("%d원 - %d개%n"),
        OUTPUT_LEFT_MONEY("투입 금액: %d원%n"),
        OUTPUT_FINAL_LEFT_MONEY("잔돈"),
        ALERT_OUT_OF_STOCK("해당 상품의 재고가 존재하지 않습니다."),
        ALERT_NO_BUDGET("투입 금액이 모자랍니다.");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
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

    public void printFinalLeftMoney(Map<Coin, Integer> leftMoney) {
        System.out.println(ConsoleMessage.OUTPUT_FINAL_LEFT_MONEY.message);
        for (Map.Entry<Coin, Integer> element : leftMoney.entrySet()) {
            System.out.printf(ConsoleMessage.OUTPUT_MACHINE_MONEY_FORMAT.message,
                    element.getKey().getAmount(), element.getValue());
        }
    }

    public void printOutOfStock() {
        System.out.println(ConsoleMessage.ALERT_OUT_OF_STOCK.message);
    }

    public void printOutOfBudget() {
        System.out.println(ConsoleMessage.ALERT_NO_BUDGET.message);
    }

}
