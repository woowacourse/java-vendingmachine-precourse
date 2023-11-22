package vendingmachine.view;

import vendingmachine.dto.ExchangeCoinsDto;

public class OutputView {
    private static final String INPUT_AMOUNT_FORMAT = "투입 금액: %d원";
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

    public
    public void printExchangeCoins(ExchangeCoinsDto dto) {
        System.out.println(START_EXCHANGE);
        dto.getCoins().forEach((coinValue, quantity) ->
                System.out.println(String.format(EXCHANGE_FORMAT, coinValue, quantity)));
    }
}
