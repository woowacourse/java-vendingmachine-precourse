package vendingmachine.coin;

import vendingmachine.Validation;

public class CoinController {
    private CoinModel coinModel;

    public CoinController() {
        this.coinModel = new CoinModel(initTotalCoin());
    }

    private int initTotalCoin() {
        String stringAmount = CoinView.inputHoldingMoney();
        int totalCoin = 0;
        try {
            Validation.checkOnlyNumber(stringAmount);
            totalCoin = Integer.parseInt(stringAmount);
            Validation.isPositiveNumber(totalCoin);
            Validation.isDivideTen(totalCoin);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 자판기 금액은 10으로 나누어 떨어지는 양의 숫자여야합니다.");
            totalCoin = initTotalCoin();
        }
        return totalCoin;
    }

    public void result() {
        coinModel.randomCoinStore();
        CoinView.outputAmount();
    }

    public void showLeftMoney(int price) {
        CoinView.outputRepay(coinModel.repayCoin(price));
    }
}
