package vendingmachine.controller;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MainController {

    /**
     * 1. 자판기가 보유한 금액을 입력받는다
     * 2. 자판기가 보유한 동전을 보여준다
     * 3. 상품명, 가격, 수량을 입력받는다
     * 4. 투입 금액을 입력받는다.
     * 5, 구매할 상품을 입력받는다. (돈 모자랄때 까지)
     * 6. 잔돈을 출력한다.
     */
    public void run() {
        InputView.inputMachineHoldMoney();
    }
}
