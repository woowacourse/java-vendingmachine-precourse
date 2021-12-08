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
    private static VendingMachine vendingMachine;
    private static User user;

    public VendingController(InputView inputView) {
        this.inputView = inputView;
    }

    public static void start() {
        setVendingMachine();
        setUser();
        while (!isEnd()) {
            tryPurchase();
            System.out.println("투입 금액: "+user.getRemainMoney()+"원");
        }
        returnChange();
    }
    private static void returnChange(){
        System.out.println("잔돈");
        vendingMachine.getCoins().calculateChange(user.getRemainMoney());
    }

    private static void tryPurchase() {
        Drink chosenDrink;
        System.out.println("구매할 상품명을 입력해주세요.");
        do {
            chosenDrink = getUserChoice();
        }while(!Validator.isRemained(chosenDrink));

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
        OutputView.showCoins(coins);
        List<Drink> drinks = getDrinkInput();
        vendingMachine = new VendingMachine(balance, coins, drinks);
    }

    private static void setUser() {
        user = new User(getUserMoneyInput());
        System.out.println("투입 금액: "+user.getRemainMoney()+"원");
    }

    private static int getUserMoneyInput() {
        String input;
        System.out.println("투입 금액을 입력해 주세요.");
        do {
            input = inputView.getInput();
        } while (!Validator.isValidateMoney(input));
        return Integer.parseInt(input);
    }

    private static List<Drink> getDrinkInput() {
        List<Drink> drinkList = new ArrayList<>();
        String input;
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
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
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        do {
            input = inputView.getInput();
        } while (!Validator.isValidateMoney(input));
        return Integer.parseInt(input);
    }

    private static Coins decideCoins(int balance) {
        Coins coins = new Coins();
        int coin500Num = getCoinNum(balance, "COIN_500");
        balance -= coin500Num * Coin.valueOf("COIN_500").getAmount();
        coins.addCoin(Coin.valueOf("COIN_500"), coin500Num);
        int coin100Num = getCoinNum(balance, "COIN_100");
        balance -= coin100Num * Coin.valueOf("COIN_100").getAmount();
        coins.addCoin(Coin.valueOf("COIN_100"), coin100Num);
        int coin50Num = getCoinNum(balance, "COIN_50");
        balance -= coin50Num * Coin.valueOf("COIN_50").getAmount();
        coins.addCoin(Coin.valueOf("COIN_50"), coin50Num);
        int coin10Num = balance/Coin.valueOf("COIN_10").getAmount();
        coins.addCoin(Coin.valueOf("COIN_10"), coin10Num);
        return coins;
    }

    private static int getCoinNum(int balance, String coin) {
        return Randoms.pickNumberInRange(0, balance / Coin.valueOf(coin).getAmount());
    }
}
