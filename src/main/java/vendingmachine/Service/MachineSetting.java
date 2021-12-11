package vendingmachine.Service;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Model.*;
import vendingmachine.SystemMessage.NoticeMessage;
import vendingmachine.Validator.Validator;
import vendingmachine.View.*;

import java.util.ArrayList;
import java.util.List;

public class MachineSetting {
    private static InputView inputView;
    private static OutputView outputView;

    public MachineSetting(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static VendingMachine execute() {
        int balance = getBalanceInput();
        Coins coins = decideCoins(balance);
        showCoins(coins);
        List<Drink> drinks = getDrinkInput();
        return new VendingMachine(balance, coins, drinks);
    }

    private static int getBalanceInput() {
        String input;
        outputView.print(NoticeMessage.ASK_BALANCE_INPUT_MESSAGE);
        do {
            input = inputView.getInput();
        } while (!Validator.isValidateMoney(input));
        return Integer.parseInt(input);
    }

    private static Coins decideCoins(int balance) {
        List<Integer> coinList = new ArrayList<>();
        List<CoinPair> coinPairs = new ArrayList<>();
        for (Coin coin : Coin.values()) {
            coinList.add(coin.getAmount());
            coinPairs.add(new CoinPair(coin, 0));
        }
        while (balance > 0) {
            balance -= pickCoinInList(coinList, coinPairs, balance);
        }
        return new Coins(coinPairs);
    }

    private static int pickCoinInList(List<Integer> coinList, List<CoinPair> coinPairs, int balance) {
        int select;
        do {
            select = Randoms.pickNumberInList(coinList);
        } while (select > balance);
        coinPairs.get(coinList.indexOf(select)).addCoinNumber();
        return select;
    }

    private static void showCoins(Coins coins) {
        outputView.print(NoticeMessage.BALANCE_COIN_MESSAGE);
        for (CoinPair coin : coins.getCoins()) {
            String coinName = coin.getCoin().name();
            coinName = coinName.substring(5, coinName.length()) + NoticeMessage.WON_MESSAGE;
            outputView.print(coinName + " - " + coin.getNumber() + NoticeMessage.EA_MESSAGE);
        }
    }

    private static List<Drink> getDrinkInput() {
        List<Drink> drinkList = new ArrayList<>();
        String input;
        outputView.print(NoticeMessage.ASK_DRINK_LIST_MESSAGE);
        do {
            input = inputView.getInput();
        } while (!Validator.isValidateDrinkList(input));
        String[] drinks = input.split(";");
        for (String drink : drinks) {
            drinkList.add(getParsedDrinkInfo(drink));
        }
        return drinkList;
    }

    private static Drink getParsedDrinkInfo(String drink) {
        drink = drink.substring(1, drink.length() - 1);
        String[] drinkInfo = drink.split(",");
        String drinkName = drinkInfo[0];
        int drinkPrice = Integer.parseInt(drinkInfo[1]);
        int drinkStock = Integer.parseInt(drinkInfo[2]);

        return new Drink(drinkName, drinkPrice, drinkStock);
    }


}
