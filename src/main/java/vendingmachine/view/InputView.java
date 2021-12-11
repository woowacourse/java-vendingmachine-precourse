package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.PossessionMoney;

public class InputView {
    private static final String POSSESSION_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    private InputView() {
    }

    public static PossessionMoney getPossessionMoney() {
        System.out.println(POSSESSION_MONEY_MESSAGE);
        return new PossessionMoney(Console.readLine());
    }
}