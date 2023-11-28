package vendingmachine.view;

import java.util.EnumMap;
import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.Coins;
import vendingmachine.view.io.Printer;

public class OutputView {
    private final Printer printer = new Printer();

    public void printMachineCoin(Coins coins) {
        printer.printMessageUsingFormat("""
                                                
                        자판기가 보유한 동전
                        500원 - %d개
                        100원 - %d개
                        50원 - %d개
                        10원 - %d개""",
                coins.getCoinCount(Coin.COIN_500),
                coins.getCoinCount(Coin.COIN_100),
                coins.getCoinCount(Coin.COIN_50),
                coins.getCoinCount(Coin.COIN_10));
    }

    public void printException(IllegalArgumentException e) {
        printer.printMessage("[ERROR] " + e.getMessage());
    }

    public void newLine() {
        printer.printMessage("");
    }

    public void printRemainMoney(int remainMoney) {
        printer.printMessageUsingFormat("투입 금액: %d원", remainMoney);
    }

    public void printReturnCoins(EnumMap<Coin, Integer> returnCoin) {
        printer.printMessage("잔돈");
        returnCoin.keySet().forEach(
                coin -> printer.printMessageUsingFormat(
                        "%d원 - %d개",
                        coin.getAmount(),
                        returnCoin.get(coin)
                ));
    }
}
