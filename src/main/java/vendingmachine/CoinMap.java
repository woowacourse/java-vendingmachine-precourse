package vendingmachine;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

public class CoinMap {
    public HashMap<Integer, Integer> coinMap = new HashMap<>();
    private final List<Integer> amountList = new ArrayList<>();

    public static final boolean ALL_PRINT = true;
    public static final boolean NON_ZERO_PRINT=false;

    public CoinMap() {
        initiateCoinMap();
    }

    private void initiateCoinMap() {
        for (Coin c : Coin.values()) {
            coinMap.put(c.getAmount(), 0);
            amountList.add(c.getAmount());
        }
    }

    public void makeCoins(int amount) {
        int pickedAmount = 0;
        while (amount > 0) {
            pickedAmount = pickNumberInList(amountList);

            if (pickedAmount > amount) {
                continue;
            }
            amount -= pickedAmount;
            coinMap.put(pickedAmount,coinMap.get(pickedAmount)+1);
        }
    }

    public void returnCoins(int userAmount){
        CoinMap returnCoinMap=new CoinMap();
        for(Integer c:coinMap.keySet()){
            int count=Math.min(coinMap.get(c),userAmount/c);
            returnCoinMap.coinMap.put(c,count);
            userAmount-=c*count;
        }
        returnCoinMap.printCoins(NON_ZERO_PRINT);
    }

    public void printCoins(boolean type) {
        if (type == ALL_PRINT) {
            for (Integer c : coinMap.keySet()) {
                System.out.println(c + "원 - " + coinMap.get(c) + "개");
            }
            return;
        }
        for (Integer c : coinMap.keySet()) {
            if (coinMap.get(c) > 0) {
                System.out.println(c + "원 - " + coinMap.get(c) + "개");
            }
        }
    }

}
