package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Simulator {

    public void start() {
        int holdingAmount = inputHoldingAmount();
        CoinContainer coinContainer = new CoinContainer();
        coinContainer.init(holdingAmount);
    }

    public int inputHoldingAmount() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String holdingAmount = Console.readLine().trim();
        InputValidator.validateInsertedAmount(holdingAmount);

        return Integer.parseInt(holdingAmount);
    }
}
