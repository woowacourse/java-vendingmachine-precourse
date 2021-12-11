package vendingmachine;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Machine {
    User user = new User();
    ArrayList<Integer> coins = new ArrayList<Integer>();
    HashMap<String, Integer> balance = new HashMap<String, Integer>();

    public void start() {
        Balance();
        coinsInMachine();
        coinHashMap();
    }

    private void Balance() {
        boolean check = false;
        while (!check) {
            System.out.println(Message.INPUT_MACHINE_BALANCE);
            check = user.inputMachineBalance();
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
        for(Coin coin: Coin.values()) {
            balance.put(String.valueOf(coin), Collections.frequency(coins, coin.getAmount()));
        }
    }
}
