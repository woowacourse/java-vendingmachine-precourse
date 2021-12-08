package vendingmachine.Controller;

import vendingmachine.Validator;
import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;
import vendingmachine.Model.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingController {

    private static InputView inputView;

    public VendingController(InputView inputView) {
        this.inputView = inputView;
    }

    public static void start() {
        int balance = getBalanceInput();
        Coins coins=decideCoins(balance);
        OutputView.showCoins(coins);
        List<Drink> drinks = getDrinkInput();
        VendingMachine vendingMachine = new VendingMachine(balance, coins, drinks);
        User user=new User(getUserMoneyInput());
    }

    private static int getUserMoneyInput(){
        String input;
        System.out.println("투입 금액을 입력해 주세요.");
        do {
            input = inputView.getInput();
        }while(!Validator.isValidateMoney(input));
        return Integer.parseInt(input);
    }

    private static List<Drink> getDrinkInput() {
        List<Drink> drinkList = new ArrayList<>();
        String input;
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        do {
            input = inputView.getInput();
        }while(!Validator.isValidateDrinkList(input));
        String[] drinks=input.split(";");
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
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        do {
            input = inputView.getInput();
        }while(!Validator.isValidateMoney(input));
        return Integer.parseInt(input);
    }

    private static Coins decideCoins(int balance) {
        Coins coins= new Coins();
        int coin500Num = getCoinNum(balance, "COIN_500");
        balance -= coin500Num * Coin.valueOf("COIN_500").getAmount();
        coins.addCoin(Coin.valueOf("COIN_500"), coin500Num);
        int coin100Num = getCoinNum(balance, "COIN_100");
        balance -= coin100Num * Coin.valueOf("COIN_100").getAmount();
        coins.addCoin(Coin.valueOf("COIN_100"), coin100Num);
        int coin50Num = getCoinNum(balance, "COIN_50");
        balance -= coin50Num * Coin.valueOf("COIN_50").getAmount();
        coins.addCoin(Coin.valueOf("COIN_50"), coin50Num);
        int coin10Num = getCoinNum(balance, "COIN_10");
        coins.addCoin(Coin.valueOf("COIN_10"), coin10Num);
        return coins;
    }

    private static int getCoinNum(int balance, String coin) {
        return Randoms.pickNumberInRange(0, balance / Coin.valueOf(coin).getAmount());
    }
}
