package vendingmachine.coin;


import java.util.List;

public class CoinController {
    private final CoinService coinService;

    public CoinController() {
        coinService = new CoinService(initCoinsAmount());
        coinService.initCoins();
    }

    public int initCoinsAmount() {
        int amount = 0;
        try {
            String inputAmount = CoinInputView.inputAmountByClient();
            // 검증로직
            amount = Integer.parseInt(inputAmount);
        } catch (IllegalArgumentException e) {
            initCoinsAmount();
        }
        return amount;
    }

    public List<Integer> repayCoins(int balance) {
        return coinService.repayCoinsByBalance(balance);
    }

    public void initCoinsPrint() {
        CoinOutputView.initCoinsPrintInfo();
    }

    public void repayCoinsPrint(int balance) {
        CoinOutputView.repayCoinsPrintInfo(repayCoins(balance));
    }
}
