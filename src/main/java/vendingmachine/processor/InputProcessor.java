package vendingmachine.processor;

import camp.nextstep.edu.missionutils.Console;

public class InputProcessor {
	private static final String RETENTION_MONEY_INPUT = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String PRODUCT_COMPOSITION_INPUT = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String INSERT_MONEY_INPUT = "투입 금액을 입력해 주세요.";
	private static final String PRODUCT_NAME_INPUT = "구매할 상품명을 입력해 주세요.";
	private final OutputProcessor outputProcessor = new OutputProcessor();

	public String readRetentionMoney() {
		outputProcessor.printMessage(RETENTION_MONEY_INPUT);
		return readLine();
	}

	public String readProductComposition() {
		outputProcessor.printMessage(PRODUCT_COMPOSITION_INPUT);
		return readLine();
	}

	public String readInsertMoney() {
		outputProcessor.printMessage(INSERT_MONEY_INPUT);
		return readLine();
	}

	public String readProductName() {
		outputProcessor.printMessage(PRODUCT_NAME_INPUT);
		return readLine();
	}

	private String readLine() {
		return Console.readLine();
	}
}
