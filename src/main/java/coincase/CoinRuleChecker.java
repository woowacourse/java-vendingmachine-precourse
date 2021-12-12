package coincase;

public class CoinRuleChecker {
	private static final int COIN_MINIMUM_UNIT = 10;
	private static final String LOGICAL_ERROR_COIN_NOT_VALID = "[ERROR] 10원 단위로 입력해 주세요.\n";

	protected boolean checkCoinMinimumUnit(int money) throws IllegalArgumentException {
		if (money % COIN_MINIMUM_UNIT == 0) {
			return true;
		}
		throw new IllegalArgumentException(LOGICAL_ERROR_COIN_NOT_VALID);
	}
}
