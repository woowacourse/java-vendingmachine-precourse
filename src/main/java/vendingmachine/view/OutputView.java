package vendingmachine.view;

import vendingmachine.dto.ExchangeCoinsDto;
import vendingmachine.dto.VendingMachineCoinsDto;

public class OutputView {
    private static final String INPUT_AMOUNT_FORMAT = "투입 금액: %d원";
    private static final String VENDING_MACHINE_AMOUNT_MESSAGE = "자판기가 보유한 동전";
    private static final String START_EXCHANGE = "잔돈";
    private static final String EXCHANGE_FORMAT = "%d원 - %d개";

    public void printError(String message) {
        System.out.println(message);
    }

    public void printInputAmount(long amount) {
        printNewLine();
        System.out.printf((INPUT_AMOUNT_FORMAT) + "%n", amount);
    }

    private void printNewLine() {
        System.out.println();
    }

    public void printVendingMachineAmount(VendingMachineCoinsDto dto) {
        printNewLine();
        System.out.println(VENDING_MACHINE_AMOUNT_MESSAGE);
        dto.getCoins().forEach((coin, quantity) ->
                System.out.println(String.format(EXCHANGE_FORMAT, coin.getAmount(), quantity)));
    }

    public void printExchangeCoins(ExchangeCoinsDto dto) {
        System.out.println(START_EXCHANGE);
        dto.getCoins().forEach((coinValue, quantity) ->
                System.out.println(String.format(EXCHANGE_FORMAT, coinValue, quantity)));
    }
}
