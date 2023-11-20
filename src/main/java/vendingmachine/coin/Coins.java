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
            changes.put(coin, 0);
            int count = coins.get(coin);
            changeMoney = getRemainChange(changeMoney, coin, count, changes);
        }

        return changes;
    }

    private static int getRemainChange(int changeMoney, Coin coin, int count, Map<Coin, Integer> changes) {
        for(int i = 0; i< count; i++){
            if(coin.getAmount() > changeMoney){
                break;
            }
            changeMoney -= coin.getAmount();
            changes.put(coin, changes.get(coin) + 1);
        }
        return changeMoney;
    }
}
