package vendingmachine.coin;

import java.util.EnumMap;
import java.util.Map;

public class Coins {
    private final Map<Coin, Integer> coins;

    public Coins(Map<Coin, Integer> coins){
        this.coins = coins;
    }

    public int getCounts(Coin coin){
        return coins.get(coin);
    }

    public Map<Coin, Integer> giveChange(int changeMoney){
        Map<Coin, Integer> changes = new EnumMap<>(Coin.class);
        for(Coin coin: Coin.values()){
            if(coin.getAmount() > changeMoney){
                changes.remove(coin);
                continue;
            }
            int count = getCount(changeMoney, coin);
            changes.put(coin, count);
            changeMoney -= coin.getAmount() * count;
            }

        return changes;
    }

    private int getCount(int changeMoney, Coin coin) {
        int count = coins.get(coin);
        while(count * coin.getAmount() > changeMoney){
            count--;
        }
        return count;
    }

}
