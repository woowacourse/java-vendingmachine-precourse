package vendingmachine.Controller;

import vendingmachine.Service.InitHoldingCoinsService;
import vendingmachine.Service.ValidatorService;
import vendingmachine.View.CoinOutputView;
import vendingmachine.View.ErrorOutputView;
import vendingmachine.View.InitView;

public class InitController {
    ValidatorService validatorService = new ValidatorService();
    InitHoldingCoinsService holdingCoinsService = new InitHoldingCoinsService();

    public void initVendingMachine() {
        initHoldingCoins();
    }

    private void initHoldingCoins() {
        holdingCoinsService.setHoldingCoins(getHoldingAmount()); // 자판기 보유금액 입력받아 자판기 동전 초기설정
        CoinOutputView.printHoldingCoins(); // 자판기 동전 출력
    }

    private int getHoldingAmount() {
        String holdingAmount = InitView.getHoldingAmount();
        try {
            validatorService.isValidHoldingAmount(holdingAmount);
        } catch (IllegalArgumentException e) {
            ErrorOutputView.printError(e.getMessage());
            getHoldingAmount();
        }
        return Integer.parseInt(holdingAmount);
    }

}
