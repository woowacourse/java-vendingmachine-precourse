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

    public int getMinimumCoinAmount(){
        int minimumAmount = Integer.MAX_VALUE;

        for(Coin currentCoin : Coin.values()){
            minimumAmount = Math.max(minimumAmount, currentCoin.getAmount());
        }

        return minimumAmount;
    }

    @Override
    public String toString(){
        StringBuilder coinValue = new StringBuilder(Integer.toString(this.amount));
        coinValue.append(StringConstants.CURRENCY_UNIT);

        return coinValue.toString();
    }
}
