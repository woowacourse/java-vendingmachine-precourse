package vendingmachine.servicesource;

import vendingmachine.constants.StringConstants;

import java.util.Arrays;
import java.util.Comparator;

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

    @Override
    public String toString(){
        StringBuilder coinValue = new StringBuilder(Integer.toString(this.amount));
        coinValue.append(StringConstants.CURRENCY_UNIT);

        return coinValue.toString();
    }
}
