package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String INPUT_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String INPUT_MACHINE_PRODUCT = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String INPUT_BUYING_MONEY = "투입 금액을 입력해 주세요.";
	private static final String INPUT_BUYING_PRODUCT = "구매할 상품명을 입력해 주세요.";

	public String enterMachineMoney() {
		System.out.println(INPUT_MACHINE_MONEY);
		return Console.readLine();
	}

	public String enterMachineProduct() {
		System.out.println(INPUT_MACHINE_PRODUCT);
		return Console.readLine();
	}

	public String enterBuyingMoney() {
		System.out.println(INPUT_BUYING_MONEY);
		return Console.readLine();
	}

	public String enterBuyingProduct() {
		System.out.println(INPUT_BUYING_PRODUCT);
		return Console.readLine();
	}
}
