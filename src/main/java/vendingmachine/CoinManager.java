package vendingmachine;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

public class CoinManager {
    private final List<Integer> amountList = new ArrayList<>();

    public CoinManager() {
        initiateCoinManager();
    }

    public void makeCoins(int amount) {
        int pickedAmount = 0;
        while (amount > 0) {
            pickedAmount = pickNumberInList(amountList);

            if (pickedAmount > amount) {
                continue;
            }
            amount -= pickedAmount;
            increaseCoinCount(pickedAmount);
        }
    }

    public void increaseCoinCount(int amount) {
        for (Coin c : Coin.values()) {
            if (c.getAmount() == amount) {
                c.increaseCount();
                break;
            }
        }
    }

    public void printCoins() {
        System.out.println("\n자판기가 보유한 동전");
        for (Coin c : Coin.values()) {
            c.printCoinInfo();
        }
    }

    public void resetCoinCount(){
        for(Coin c:Coin.values()){
            c.resetCount();
        }
    }

    public void returnCoins(int userAmount) {
        System.out.println("잔돈");
        for (Coin c : Coin.values()) {
            userAmount = c.returnCoin(userAmount);
        }
    }

    private void initiateCoinManager() {
        for (Coin c : Coin.values()) {
            amountList.add(c.getAmount());
        }
    }
}
