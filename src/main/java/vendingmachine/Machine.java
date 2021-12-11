package vendingmachine;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class Machine {
    User user = new User();
    ArrayList<Integer> coins = new ArrayList<>();
    HashMap<Coin, Integer> coinsMap = new HashMap<>();
    private int userAmount;

    public void start() {
        balance();
        coinsInMachine();
        coinHashMap();
        showMachineCoins();
        goods();
        amountInput();
        purchase();
    }
    private void balance() {
        boolean check = false;
        while (!check) {
            System.out.println(Message.INPUT_MACHINE_BALANCE);
            check = user.inputMachineBalance();
        }
    }
    private void goods() {
        boolean check = false;
        System.out.println();
        while (!check) {
            System.out.println(Message.INPUT_MACHINE_Goods);
            check = user.inputGoods();
        }
    }
    private void coinsInMachine() {
        int balance = user.getMachineBalance();
        int coin;
        while (balance > 0) {
            coin = randomCoin();
            if (coin == user.getMachineBalance()) {
                continue;
            }
            if(coin <= balance) {
                coins.add(coin);
                balance = balance - coin;
            }
        }
    }
    private int randomCoin() {
        return Randoms.pickNumberInList(Coin.getCoinsList());
    }
    private void coinHashMap() {
        for(Coin coin : Coin.values()) {
            coinsMap.put(coin, Collections.frequency(coins, coin.getAmount()));
        }
    }
    private void showMachineCoins() {
        System.out.println("\n" + Message.SHOW_MACHINE_COINS);
        System.out.println(Coin.COIN_500.getAmount() + Message.WON_SPACE_BAR_SPACE + coinsMap.get(Coin.COIN_500) + Message.QUANTITY);
        System.out.println(Coin.COIN_100.getAmount() + Message.WON_SPACE_BAR_SPACE + coinsMap.get(Coin.COIN_100) + Message.QUANTITY);
        System.out.println(Coin.COIN_50.getAmount() + Message.WON_SPACE_BAR_SPACE + coinsMap.get(Coin.COIN_50) + Message.QUANTITY);
        System.out.println(Coin.COIN_10.getAmount() + Message.WON_SPACE_BAR_SPACE + coinsMap.get(Coin.COIN_10) + Message.QUANTITY);
    }
    private void amountInput() {
        boolean check = false;
        System.out.println();
        while (!check) {
            System.out.println(Message.INPUT_USER_AMOUNT);
            check = user.inputUserAmount();
        }
    }
    private void buyGoods() {
        boolean check = false;
        while (!check) {
            System.out.println(Message.INPUT_BUY_PRODUCT);
            check = user.inputUserGoods();
        }
        user.userPurchase();
    }
    private void purchase() {
        boolean check = false;
        while (!check) {
            user.showRemainingAmount();
            check = user.availablePurchase();
            if (!check) {
                buyGoods();
            }
        }
        returnBalance();
        showReturnBalance();
    }
    private void returnBalance() {
        userAmount = user.getUserAmount();
        eachBalance(Coin.COIN_500);
        eachBalance(Coin.COIN_100);
        eachBalance(Coin.COIN_50);
        eachBalance(Coin.COIN_10);
    }
    private void eachBalance(Coin coin) {
        int count = Math.min(userAmount / coin.getAmount(), coinsMap.get(coin));
        coinsMap.put(coin, count);
        userAmount -= count * coin.getAmount();
    }
    private void showReturnBalance() {
        System.out.println(Message.RETURN_BALANCE);
        if (!(coinsMap.get(Coin.COIN_500) == 0)) {
            System.out.println(Coin.COIN_500.getAmount() + Message.WON_SPACE_BAR_SPACE + coinsMap.get(Coin.COIN_500) + Message.QUANTITY);
        }
        if (!(coinsMap.get(Coin.COIN_100) == 0)) {
            System.out.println(Coin.COIN_100.getAmount() + Message.WON_SPACE_BAR_SPACE + coinsMap.get(Coin.COIN_100) + Message.QUANTITY);
        }
        if (!(coinsMap.get(Coin.COIN_50) == 0)) {
            System.out.println(Coin.COIN_50.getAmount() + Message.WON_SPACE_BAR_SPACE + coinsMap.get(Coin.COIN_50) + Message.QUANTITY);
        }
        if (!(coinsMap.get(Coin.COIN_10) == 0)) {
            System.out.println(Coin.COIN_10.getAmount() + Message.WON_SPACE_BAR_SPACE + coinsMap.get(Coin.COIN_10) + Message.QUANTITY);
        }
    }
}
