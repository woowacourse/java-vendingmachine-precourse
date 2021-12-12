package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

import vendingmachine.domain.Money;
import vendingmachine.dto.RequestHoldingMoneyDto;

public class InputView {
	private static final String REQUEST_HOLDING_AMOUNT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public static RequestHoldingMoneyDto inputHoldingMoney() {
		System.out.println(REQUEST_HOLDING_AMOUNT_MESSAGE);
		Money money = new Money(readLine());
		return new RequestHoldingMoneyDto(money);
	}
}
