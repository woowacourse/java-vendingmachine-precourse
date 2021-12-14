package vendingmachine.io;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collectors;
import vendingmachine.domain.Coin;
import vendingmachine.domain.HoldingAmount;
import vendingmachine.domain.Changes;
import vendingmachine.domain.InputAmount;

public class ConsolePrinter {

    private static final String CHANGE_DELIMITER = " - ";
    private static final String CHANGE_HEADER = "잔돈";
    private static final String HOLDING_AMOUNT_HEADER = "자판기가 보유한 동전";
    private static final String INPUT_AMOUNT_PREFIX = "투입 금액: ";
    private static final String COIN_COUNT_SUFFIX = "개";
    private static final String CURRENCY_UNIT = "원";
    private static final String LINE_BREAK = "\n";
    private static final int NO_COIN = 0;

    private PrintStream printStream;

    public ConsolePrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    public ConsolePrinter() {
        this.printStream = System.out;
    }

    public void printChanges(Changes changes) {
        printStream.println(CHANGE_HEADER);
        printValidPayLoad(Arrays.stream(Coin.values())
            .filter(coin -> changes.getCoinCount(coin) > NO_COIN)
            .map(coin -> parseCoinCount(coin, changes.getCoinCount(coin)))
            .collect(Collectors.joining(LINE_BREAK)));
    }

    public void printHoldingAmount(HoldingAmount holdingAmount) {
        printStream.println(HOLDING_AMOUNT_HEADER);
        printStream.println(Arrays.stream(Coin.values())
            .map(coin -> parseCoinCount(coin, holdingAmount.getHoldingCoinCount(coin)))
            .collect(Collectors.joining(LINE_BREAK)));
    }

    public void printInputAmount(InputAmount inputAmount) {
        printStream.println(String.join("",
            INPUT_AMOUNT_PREFIX, String.valueOf(inputAmount.getAmount()), CURRENCY_UNIT));
    }

    private String parseCoinCount(Coin coin, int count) {
        return String.join("",
            coin.getLocalCurrency(), CHANGE_DELIMITER, String.valueOf(count), COIN_COUNT_SUFFIX);
    }

    private void printValidPayLoad(String payload) {
        if (!payload.isEmpty()) {
            printStream.println(payload);
        }
    }
}
