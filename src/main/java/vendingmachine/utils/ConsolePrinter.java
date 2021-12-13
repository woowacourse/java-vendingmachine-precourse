package vendingmachine.utils;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collectors;
import vendingmachine.Coin;
import vendingmachine.domain.Changes;

public class ConsolePrinter {

    private static final String CHANGE_DELIMITER = " - ";
    private static final String CHANGE_HEADER = "잔돈";
    private static final String COIN_COUNT_SUFFIX = "개";
    private static final String LINE_BREAK = "\n";
    private static final int NO_COIN = 0;

    private final PrintStream printStream;

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

    private String parseCoinCount(Coin coin, int count) {
        return String.join("",
            coin.getName(), CHANGE_DELIMITER, String.valueOf(count), COIN_COUNT_SUFFIX);
    }

    private void printValidPayLoad(String payload) {
        if (!payload.isEmpty()) {
            printStream.println(payload);
        }
    }
}
