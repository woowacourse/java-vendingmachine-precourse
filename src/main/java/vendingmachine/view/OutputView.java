package vendingmachine.view;

import java.util.Arrays;
import java.util.Map;
import vendingmachine.coin.Coin;
import vendingmachine.coin.Coins;
import vendingmachine.view.io.Printer;

public class OutputView {
    private OutputView(){}

    public static void printCoins(Coins coins) {
        Printer.printMessage("자판기가 보유한 동전");
        Arrays.stream(Coin.values())
                .forEach(coin ->
                        Printer.printUsingFormat("%d원 - %d개", coin.getAmount(), coins.getCounts(coin)));
    }

    public static void printRemainMoney(int remainMoney) {
        Printer.printUsingFormat("투입 금액: %d원", remainMoney);
    }

    public static void printChange(Map<Coin, Integer> changes){
        Printer.printMessage("잔돈");
        Arrays.stream(Coin.values())
                .filter(changes::containsKey)
                .forEach(coin ->
                        Printer.printUsingFormat("%d원 - %d개",
                                coin.getAmount(), changes.get(coin)));
    }
}
