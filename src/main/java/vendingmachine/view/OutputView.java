package vendingmachine.view;

import static vendingmachine.constants.OutputMessages.*;
import static vendingmachine.constants.FormatConstants.*;

import vendingmachine.domain.enums.Coin;

import java.util.HashMap;
import java.util.TreeMap;

public class OutputView {

    public static void printCoinsInfo(HashMap<Coin, Integer> coins) {
        StringBuilder sb = new StringBuilder();
        sb.append(COINS_IN_VENDING_MACHINE).append(BLANK_LINE);

        for (Coin coin : Coin.getCoinsDesc()) {
            sb.append(coin.getAmountFormat()).append(COIN_PRINT_SEPARATOR);
            sb.append(coins.get(coin)).append(COIN_AMOUNT_DIGIT);
            sb.append(BLANK_LINE);
        }

        System.out.println(sb);
    }

    public static void printMoneyLeft(int moneyLeft) {
        System.out.println(MONEY_INPUT + moneyLeft + WON);
    }

    public static void printCoinChanges(TreeMap<Coin, Integer> coinChanges) {
        StringBuilder sb = new StringBuilder();
        sb.append(CHANGES).append(BLANK_LINE);

        for (Coin coin : coinChanges.keySet()) {
            sb.append(coin.getAmountFormat()).append(COIN_PRINT_SEPARATOR);
            sb.append(coinChanges.get(coin)).append(COIN_AMOUNT_DIGIT);
            sb.append(BLANK_LINE);
        }

        System.out.println(sb);
    }
}