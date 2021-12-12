package vendingmachine.Service;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Constant.Constant;
import vendingmachine.Model.*;
import vendingmachine.SystemMessage.NoticeMessage;
import vendingmachine.Validator.*;
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
        coins.showCoins(outputView);
        List<Drink> drinks = getDrinkInput();
        return new VendingMachine(coins, drinks);
    }

    private static int getBalanceInput() {
        String input;
        outputView.print(NoticeMessage.ASK_BALANCE_INPUT_MESSAGE);
        do {
            input = inputView.getInput();
        } while (!MoneyValidator.isValidateMoney(input));
        return Integer.parseInt(input);
    }

    private static Coins decideCoins(int balance) {
        List<Integer> coinAmountList = new ArrayList<>();
        List<CoinPair> coinPairs = new ArrayList<>();
        for (Coin coin : Coin.values()) {
            coinAmountList = coin.addAmountToList(coinAmountList);
            coinPairs.add(new CoinPair(coin, Constant.ZERO));
        }
        while (balance > Constant.ZERO) {
            balance -= pickCoinInList(coinAmountList, coinPairs, balance);
        }
        return new Coins(coinPairs);
    }

    private static int pickCoinInList(List<Integer> coinAmountList, List<CoinPair> coinPairs, int balance) {
        int select;
        do {
            select = Randoms.pickNumberInList(coinAmountList);
        } while (select > balance);
        coinPairs.get(coinAmountList.indexOf(select)).addCoinNumber();
        return select;
    }

    private static List<Drink> getDrinkInput() {
        List<Drink> drinkList = new ArrayList<>();
        String input;
        outputView.print(NoticeMessage.ASK_DRINK_LIST_MESSAGE);
        do {
            input = inputView.getInput();
        } while (!DrinkListValidator.isValidateDrinkList(input));

        String[] drinks = input.split(Constant.SEMICOLON);
        for (String drink : drinks) {
            drinkList.add(getParsedDrinkInfo(drink.trim()));
        }
        return drinkList;
    }

    private static Drink getParsedDrinkInfo(String drink) {
        drink = drink.substring(Constant.ONE, drink.length() - Constant.ONE);
        String[] drinkInfo = drink.split(Constant.COMMA);
        String drinkName = drinkInfo[Constant.NAME_INDEX].trim();
        int drinkPrice = Integer.parseInt(drinkInfo[Constant.PRICE_INDEX].trim());
        int drinkStock = Integer.parseInt(drinkInfo[Constant.STOCK_INDEX].trim());

        return new Drink(drinkName, drinkPrice, drinkStock);
    }
}
