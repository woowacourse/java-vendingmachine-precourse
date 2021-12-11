package vendingmachine;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Machine {
    User user = new User();
    ArrayList<Integer> coins = new ArrayList<>();
    HashMap<Coin, Integer> coinsMap = new HashMap<>();

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
        System.out.println("\n"+Message.SHOW_MACHINE_COINS);
        System.out.println(Coin.COIN_500.getAmount() + "원 - " + coinsMap.get(Coin.COIN_500) + "개");
        System.out.println(Coin.COIN_100.getAmount() + "원 - " + coinsMap.get(Coin.COIN_100) + "개");
        System.out.println(Coin.COIN_50.getAmount() + "원 - " + coinsMap.get(Coin.COIN_50) + "개");
        System.out.println(Coin.COIN_10.getAmount() + "원 - " + coinsMap.get(Coin.COIN_10) + "개");
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

    }
}
