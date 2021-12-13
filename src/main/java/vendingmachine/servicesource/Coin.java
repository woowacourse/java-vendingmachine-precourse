package vendingmachine.servicesource;

import vendingmachine.constants.StringConstants;

public enum Coin {
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

    @Override
    public String toString(){
        StringBuilder coinValue = new StringBuilder(Integer.toString(this.amount));
        coinValue.append(StringConstants.CURRENCY_UNIT);

        return coinValue.toString();
    }
}
