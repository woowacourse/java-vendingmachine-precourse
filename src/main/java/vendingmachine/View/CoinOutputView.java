package vendingmachine.View;

import vendingmachine.Constant.OutputConstant;
import vendingmachine.Domain.HoldingCoins;

public class CoinOutputView {

    public static void printHoldingCoins() {
        System.out.println(OutputConstant.PRINT_COIN);
        System.out.println(HoldingCoins.printCoins());
    }
}
