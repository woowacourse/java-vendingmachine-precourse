package vendingmachine;

/**
 * 자판기의 출력창 역할을 하는 view class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class Display {
	private static final String HOLDING_AMOUNT_QUESTION = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String ITEM_QUESTION = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String ALL_COIN_TITLE = "자판기가 보유한 동전";

	private static final String COIN_FORMAT = "%d원 - %d개%n";
	private static final String ERROR_FORMAT = "[ERROR] %s%n";

	public void askHoldingAmount() {
		System.out.println(HOLDING_AMOUNT_QUESTION);
	}

	public void askItems() {
		System.out.println(ITEM_QUESTION);
	}

	public void printCoin(Coin coin) {
		System.out.printf(COIN_FORMAT, coin.getAmount(), coin.getCount());
	}

	public void printAllCoin() {
		System.out.println(ALL_COIN_TITLE);
		for(Coin coin : Coin.values()) {
			printCoin(coin);
		}
	}

	public void printBlankLine() {
		System.out.println();
	}

	public void printError(Exception e) {
		System.out.printf(ERROR_FORMAT, e.getMessage());
	}
}
