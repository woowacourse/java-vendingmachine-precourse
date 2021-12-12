package vendingmachine.View;

import vendingmachine.Constant.ErrorConstant;
import vendingmachine.Constant.OutputConstant;
import vendingmachine.Domain.Coin;
import vendingmachine.Domain.HoldingCoins;
import vendingmachine.Domain.InputAmount;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public static void printError(String message) {
        System.out.println(ErrorConstant.ERROR_OCCURRED + message);
    }

    public static void printInputAmount() {
        System.out.println(InputAmount.printInputAmount());
    }

    public static void printHoldingCoins() {
        System.out.println(OutputConstant.PRINT_COIN);
        printCoins(Arrays.asList(Coin.values()));
    }

    public static void printCoins(List<Coin> coins) {
        StringBuilder result = new StringBuilder();
        for (Coin c : coins) {
            result.append(printCoin(c));
        }

        System.out.println(result);
    }

    private static String printCoin(Coin c) {
        StringBuilder result = new StringBuilder();
        result.append(c.printAmount());
        result.append(OutputConstant.COIN_STANDARD);
        result.append(HoldingCoins.printCoinCount(c));
        result.append("\n");

        return result.toString();
    }
}
