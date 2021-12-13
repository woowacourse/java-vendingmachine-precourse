package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class Exchanger {
    private Map<String,Integer> exchangedCoins = new HashMap<>();
    public Exchanger(){
        exchangedCoins.put("COIN_500",0);
        exchangedCoins.put("COIN_100",0);
        exchangedCoins.put("COIN_50",0);
        exchangedCoins.put("COIN_10",0);
    }

    public Map<String, Integer> getExchangedCoins() {
        return exchangedCoins;
    }

    public void exchange(int leftMoney){
        applyExchangeAlgorithm(leftMoney);
   }
   private void applyExchangeAlgorithm(int leftMoney){
        int tempLeftMoney = leftMoney;
        tempLeftMoney = saveNeededCoinNumber(tempLeftMoney,500);
        tempLeftMoney = saveNeededCoinNumber(tempLeftMoney,100);
        tempLeftMoney = saveNeededCoinNumber(tempLeftMoney,50);
        saveNeededCoinNumber(tempLeftMoney,10);
    }

    private int saveNeededCoinNumber(int leftMoney, int coin){
        String coinKind = "COIN_"+coin;
        int leftCoin = Coin.valueOf(coinKind).getNumber();
        if( leftCoin>= 1 && leftMoney / coin >=1){
            int neededCoinNumber = leftMoney / coin;
            int exchangedCoins = calculateLeftCoin(neededCoinNumber,coinKind);
            leftMoney = leftMoney - coin * exchangedCoins;
        }
        return leftMoney;
    }
    private int calculateLeftCoin(int neededNumber, String coinKind){
        int leftCoin = Coin.valueOf(coinKind).getNumber();
        int exchangedCoinNumber = exchangedCoins.get(coinKind);
        if(leftCoin <= neededNumber){
            exchangedCoins.put(coinKind,exchangedCoinNumber + leftCoin);
            Coin.valueOf(coinKind).decreaseNumber(leftCoin);
            return leftCoin;
        }
        exchangedCoins.put(coinKind,exchangedCoinNumber + neededNumber);
        Coin.valueOf(coinKind).decreaseNumber(neededNumber);
        return neededNumber;
    }
}
