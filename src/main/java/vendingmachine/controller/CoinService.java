package vendingmachine.controller;

public class CoinService {

    private final int holdMoney;

    public CoinService(final int holdMoney) {
        this.holdMoney = holdMoney;
    }

    public static CoinService from(final int holdMoney) {
        return new CoinService(holdMoney);
    }
}
