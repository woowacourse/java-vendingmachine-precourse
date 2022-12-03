package vendingmachine.domain;

import vendingmachine.enums.Coin;

import java.util.ArrayList;
import java.util.List;

public class Change {
    private final int amount;
    private final int[] coins;

    public Change(int amount) {
        this.amount = amount;
        coins = makeCoins(amount);
    }

    private int[] makeCoins(int amount) {
        int[] coins = new int[4];
        while (amount != 0) {
            int coin = getUnderAmountCoin(amount);
            int coinIndex = Coin.getIndex(coin);
            coins[coinIndex]++;
            amount -= coin;
        }
        return coins;
    }
    private int getUnderAmountCoin(int amount){
        int coin = Coin.getRandomCoin();
        while( amount < coin){
            coin = Coin.getRandomCoin();
        }
        return coin;
    }
    public int getAmount(){
        return amount;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append("500원 - "+ coins[0]+"개\n");
        print.append("100원 - "+ coins[1]+"개\n");
        print.append("50원 - "+ coins[2]+"개\n");
        print.append("10원 - "+ coins[3]+"개\n");
        return print.toString();
    }
    public String lastChangePrint(){
        StringBuilder print = new StringBuilder();
        for(int index = 0; index < coins.length; index++){
            if(coins[index]!=0){
                if(index == 0)print.append("500원 - "+coins[index]+"개\n");
                if(index == 1)print.append("100원 - "+coins[index]+"개\n");
                if(index == 2)print.append("50원 - "+coins[index]+"개\n");
                if(index == 3)print.append("10원 - "+coins[index]+"개\n");

            }
        }
        return print.toString();
    }
}
