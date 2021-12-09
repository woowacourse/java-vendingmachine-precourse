package vendingmachine.coin;


import vendingmachine.ValidatorMessage;

import java.util.List;

public class CoinController {
    private final CoinService coinService;

    public CoinController() {
        coinService = new CoinService(initCoinsAmount());
        coinService.initCoins();
    }

    public int initCoinsAmount() {
        int amount;
        try {
            String inputAmount = CoinInputView.inputAmountByClient();
            CoinValidator.validateAmount(inputAmount);
            amount = Integer.parseInt(inputAmount);
        } catch (IllegalArgumentException e) {
            ValidatorMessage.printError(e.getMessage());
            amount = initCoinsAmount();
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
