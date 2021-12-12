package vendingmachine.utils;

public class Formatter {
	private static final String KOREAN_CURRENCY_UNIT = "원";
	private static final String KOREAN_ITEM_COUNT_UNIT = "원";

	public static String formatToKoreanCurrencyUnit(String price) {
		return price + KOREAN_CURRENCY_UNIT;
	}

	public static String formatToKoreanCurrencyUnit(int price) {
		return price + KOREAN_CURRENCY_UNIT;
	}

	public static String formatToKoreanItemCountUnit(String count) {
		return count + KOREAN_ITEM_COUNT_UNIT;
	}

	public static String formatToKoreanItemCountUnit(int count) {
		return count + KOREAN_ITEM_COUNT_UNIT;
	}
}
