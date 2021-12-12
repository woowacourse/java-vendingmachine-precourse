package vendingmachine;

import java.text.MessageFormat;
import java.util.Map;

public class ConsolePrinter {
    private static final String VENDING_MACHINE_INFORMATION = "{0}원 - {1}개";

    private ConsolePrinter() {}

    public static void print(Map<Coin, Integer> coinMap, Message headMessage) {
        System.out.println(headMessage.getMessage());
        for (Coin coin : coinMap.keySet()) {
            System.out.println(MessageFormat.format(VENDING_MACHINE_INFORMATION, coin.getAmount(), coinMap.get(coin)));
        }
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
