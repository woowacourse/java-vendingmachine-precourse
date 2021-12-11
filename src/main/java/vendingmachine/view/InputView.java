package vendingmachine.view;

import java.util.Scanner;

public class InputView {
	private static final String HOLDING_MONEY_GUIDE_MESSEAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	private final Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public String scanHoldingMoney() {
		System.out.println(HOLDING_MONEY_GUIDE_MESSEAGE);
		return scanner.nextLine();
	}
}
