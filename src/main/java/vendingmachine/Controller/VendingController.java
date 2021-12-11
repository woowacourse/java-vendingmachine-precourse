package vendingmachine.Controller;

import vendingmachine.Validator.Validator;
import vendingmachine.View.*;
import vendingmachine.Model.*;
import vendingmachine.SystemMessage.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingController {

    private static InputView inputView;
    private static OutputView outputView;
    private static VendingMachine vendingMachine;
    private static User user;

    public VendingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static void start() {
        setVendingMachine();
        setUser();
        while (!isEnd()) {
            tryPurchase();
            outputView.print(NoticeMessage.INPUT_MONEY_MESSAGE + user.getRemainMoney() + NoticeMessage.WON_MESSAGE);
        }
        returnChange();
    }

    private static void returnChange() {
        outputView.print(NoticeMessage.CHANGE_MESSAGE);
        calculateChange(vendingMachine.getCoins().getCoins(), user.getRemainMoney());
    }

    public static void calculateChange(List<CoinPair> coins, int remainMoney) {
        for (CoinPair coinPair : coins) {
            remainMoney -= payCoin(coinPair, remainMoney);
        }
    }

    private static int payCoin(CoinPair coinPair, int remainMoney) {
        String coinName = coinPair.getCoin().name();
        coinName = coinName.substring(5) + NoticeMessage.WON_MESSAGE;
        int requiredCoins = remainMoney / coinPair.getCoin().getAmount();
        if (coinPair.getNumber() == 0 || requiredCoins == 0) {
            return 0;
        }
        if (requiredCoins >= coinPair.getNumber()) {
            outputView.print(coinName + " - " + coinPair.getNumber() + NoticeMessage.EA_MESSAGE);
            return coinPair.getNumber() * coinPair.getCoin().getAmount();
        }
        outputView.print(coinName + " - " + requiredCoins + NoticeMessage.EA_MESSAGE);
        return requiredCoins * coinPair.getCoin().getAmount();
    }

    private static void tryPurchase() {
        Drink chosenDrink;
        System.out.println(NoticeMessage.ASK_DRINK_NAME_MESSAGE);
        do {
            chosenDrink = getUserChoice();
        } while (!Validator.isRemained(chosenDrink));

        chosenDrink.subtractStock();
        user.pay(chosenDrink);
    }

    private static Drink getUserChoice() {
        String userChoice;
        do {
            userChoice = inputView.getInput();
        } while (!Validator.isValidateChoice(userChoice, vendingMachine));
        return vendingMachine.findDrinkWithName(userChoice);
    }

    private static boolean isEnd() {
        if (vendingMachine.isEmpty() || !user.isPurchasable(vendingMachine.getMinimumPrice())) {
            return true;
        }
        return false;
    }

    private static void setVendingMachine() {
        int balance = getBalanceInput();
        Coins coins = decideCoins(balance);
        showCoins(coins);
        List<Drink> drinks = getDrinkInput();
        vendingMachine = new VendingMachine(balance, coins, drinks);
    }

    public static void showCoins(Coins coins) {
        outputView.print(NoticeMessage.BALANCE_COIN_MESSAGE);
        for (CoinPair coin : coins.getCoins()) {
            String coinName = coin.getCoin().name();
            coinName = coinName.substring(5, coinName.length()) + NoticeMessage.WON_MESSAGE;
            outputView.print(coinName + " - " + coin.getNumber() + NoticeMessage.EA_MESSAGE);
        }
    }

    private static void setUser() {
        user = new User(getUserMoneyInput());
        outputView.print(NoticeMessage.INPUT_MONEY_MESSAGE + user.getRemainMoney() + NoticeMessage.WON_MESSAGE);
    }

    private static int getUserMoneyInput() {
        String input;
        outputView.print(NoticeMessage.ASK_MONEY_INPUT_MESSAGE);
        do {
            input = inputView.getInput();
        } while (!Validator.isValidateMoney(input));
        return Integer.parseInt(input);
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
}
