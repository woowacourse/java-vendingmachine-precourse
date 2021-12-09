package vendingmachine.coin;


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

    public void initCoinsPrint() {
        CoinOutputView.initCoinsPrintInfo();
    }
}
