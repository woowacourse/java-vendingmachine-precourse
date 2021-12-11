package vendingmachine.view;

import vendingmachine.dto.CoinsDto;

public class OutputView {
	private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

	private static final int EMPTY_COIN_QUANTITY = 0;

	private static final String COIN_500 = "500원";
	private static final String COIN_100 = "100원";
	private static final String COIN_50 = "50원";
	private static final String COIN_10 = "10원";

	private static final String INPUT_VENDING_MACHINE_BALANCE_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String VENDING_MACHINE_HOLDING_COINS_MESSAGE = "\n자판기가 보유한 동전";
	private static final String INPUT_ITEMS_MESSAGE = "\n상품명과 가격, 수량을 입력해 주세요.";
	private static final String INPUT_USER_BALANCE_MESSAGE = "\n투입 금액을 입력해 주세요.";
	private static final String CURRENT_USER_BALANCE_FORMAT = "\n투입 금액: %d원";
	private static final String INPUT_ITEM_TO_BUY_MESSAGE = "구매할 상품명을 입력해 주세요.";
	private static final String CHANGE_MESSAGE = "잔돈";
	private static final String COIN_OUTPUT_FORMAT = "%s - %s개";
	private static final String NO_CHANGE_MESSAGE = "반환할 잔돈이 없습니다.";

	public static void printError(String message) {
		System.out.println(ERROR_MESSAGE_PREFIX + message);
	}

	public static void printInputVendingMachineBalance() {
		System.out.println(INPUT_VENDING_MACHINE_BALANCE_MESSAGE);
	}

	public static void printVendingMachineHoldingCoins(CoinsDto coinsDto) {
		System.out.println(VENDING_MACHINE_HOLDING_COINS_MESSAGE);
		printCoin(COIN_500, coinsDto.getCoin500Quantity());
		printCoin(COIN_100, coinsDto.getCoin100Quantity());
		printCoin(COIN_50, coinsDto.getCoin50Quantity());
		printCoin(COIN_10, coinsDto.getCoin10Quantity());
	}

	public static void printChange(CoinsDto coinsDto) {
		System.out.println(CHANGE_MESSAGE);

		printCoinIgnoringZero(COIN_500, coinsDto.getCoin500Quantity());
		printCoinIgnoringZero(COIN_100, coinsDto.getCoin100Quantity());
		printCoinIgnoringZero(COIN_50, coinsDto.getCoin50Quantity());
		printCoinIgnoringZero(COIN_10, coinsDto.getCoin10Quantity());

		if (coinsDto.getAllCoinQuantity() == EMPTY_COIN_QUANTITY) {
			System.out.println(NO_CHANGE_MESSAGE);
		}
	}

	public static void printInputItems() {
		System.out.println(INPUT_ITEMS_MESSAGE);
	}

	private static void printCoin(String type, int coinQuantity) {
		System.out.println(String.format(COIN_OUTPUT_FORMAT, type, coinQuantity));
	}

	private static void printCoinIgnoringZero(String type, int coinQuantity) {
		if (coinQuantity > 0) {
			System.out.println(String.format(COIN_OUTPUT_FORMAT, type, coinQuantity));
		}
	}

	public static void printInputUserBalance() {
		System.out.println(INPUT_USER_BALANCE_MESSAGE);
	}

	public static void printCurrentUserBalance(int userBalance) {
		System.out.println(String.format(CURRENT_USER_BALANCE_FORMAT, userBalance));
	}

	public static void printInputItemToBuy() {
		System.out.println(INPUT_ITEM_TO_BUY_MESSAGE);
	}
}
