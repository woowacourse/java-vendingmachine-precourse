package vendingmachine.servicesource;

import vendingmachine.constants.StringConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum Coin{
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    static public Coin getMinimumAmountCoin(){
        Coin minimumCoin = null;

        for(Coin currentCoin : Coin.values()){

            if(minimumCoin == null || currentCoin.getAmount() < minimumCoin.getAmount()){
                minimumCoin = currentCoin;
            }

        }

        return minimumCoin;
    }

    static public Coin[] getSortedCoinTypes(){
        Coin[] coinTypes = Coin.values();

        Arrays.sort(coinTypes, new Comparator<Coin>() {
            @Override
            public int compare(Coin o1, Coin o2) {
                return o2.getAmount() - o1.getAmount();
            }
        });

        return coinTypes;
    }

    static public List<Integer> getAmountsListLowerThanBalance(int balance){
        List<Integer> amountOfCoins = new ArrayList<>();

        for(Coin currentCoin : Coin.values()){

            if(currentCoin.getAmount() <= balance){
                amountOfCoins.add(currentCoin.getAmount());
            }

        }

        return amountOfCoins;
    }

    @Override
    public String toString(){
        StringBuilder coinValue = new StringBuilder(Integer.toString(this.amount));
        coinValue.append(StringConstants.CURRENCY_UNIT);

        return coinValue.toString();
    }
}
