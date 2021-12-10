package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class VendingMachine {
    private int price;
    private List<Integer> coins;

    public VendingMachine(int price){
        this.price = price;
        setCoins();
    }

    private void setCoins(){
        int nowPrice = this.price;
        int[] coinList = new int[4];
        while(nowPrice > 0){
            for(Coin coin : Coin.values()) {
                int quantity = coin.convertPriceToCoins(coin, nowPrice);
                coinList[coin.ordinal()] += quantity;
                nowPrice -= coin.calculate(quantity);
            }
        }
        this.coins = Arrays.stream(coinList)
                .boxed()
                .collect(Collectors.toList());
    }
}
