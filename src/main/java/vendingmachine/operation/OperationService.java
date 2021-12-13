package vendingmachine.operation;

import java.util.EnumMap;
import java.util.Map;

import vendingmachine.Coin;
import vendingmachine.management.Commodity;
import vendingmachine.management.CommodityRepository;
import vendingmachine.operation.validation.CheckCommoditySelection;

public class OperationService {
    public static int calculateBalance(Commodity commodity, int balance) {
        CheckCommoditySelection.validationOutOfBalance(commodity, balance);
        CheckCommoditySelection.validationSoldOut(commodity);
        return balance - commodity.getPrice();
    }

    public static void reduceCommodityQuantity(Commodity commodity) {
        CommodityRepository.reduceQuantity(commodity);
    }
    
    public static Map<Coin,Integer> getLeastNumberOfCoin(int balance) {
        Map<Coin,Integer> coinMap = new EnumMap<>(Coin.class);
        Coin[] coins = Coin.values();
        int idx = 0;
        
        while(balance > 0 && idx < coins.length) {
            if(coins[idx].getNumber() == 0 || coins[idx].getAmount() > balance) {
                idx++;
                continue;
            }
            balance = reduceBalance(balance,coins[idx]);
            coinMap.put(coins[idx], coinMap.getOrDefault(coins[idx], 0)+1);
        }
        return coinMap;
    }

    private static int reduceBalance(int balance, Coin coinType) {
        Coin.deleteNumber(coinType);
        return balance - coinType.getAmount();
    }
}
