package vendingmachine.constant;

public class SystemMessage {

	/**
	 * InputView
	 */
	public static final String INPUT_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String INPUT_MONEY_TO_BUY = "투입 금액을 입력해 주세요.";
	public static final String INPUT_ITEM_NAMES = "상품명과 가격, 수량을 입력해 주세요.";

	/**
	 * OutputView
	 */
	public static final String OUTPUT_MACHINE_MONEY = "자판기가 보유한 동전";
	public static final String OUTPUT_CHANGES = "투입 금액: 500원\n잔돈";

	/**
	 * Coin
	 */
	public static final String SELF_DESCRIPTION_FORMAT = "%d원 - %d개\n";

	public static final void printEmptyLine() {
		System.out.println("");
	}
}
