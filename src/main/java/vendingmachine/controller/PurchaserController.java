package vendingmachine.controller;

import static vendingmachine.view.constant.InputMessage.*;

import vendingmachine.domain.Purchaser;
import vendingmachine.exception.ExceptionHandler;
import vendingmachine.util.InputUtil;
import vendingmachine.util.Parser;
import vendingmachine.view.output.OutputView;

public class PurchaserController {
    private static int money;
    private PurchaserController(){
    }

    public static Purchaser requestPurchaseOrder(){
        requestUserCoin();
        return Purchaser.from(money);
    }

    private static void requestUserCoin(){
        OutputView.println(REQUEST_INPUT_AMOUNT.getMessage());
        money = ExceptionHandler.retryOnBusinessException(PurchaserController::createPurchaserMoneyFromInput);
    }

    private static int createPurchaserMoneyFromInput() {
        String money = InputUtil.readLine();
        return Parser.parseMoneyInput(money);
    }
}
