package vendingmachine;

public final class Constants {
	public static final String HYPHEN = "-";
	public static final String LINE_FEED = "\n";
	public static final int TEN = 10;
	public static final int INDEX_OF_NAME_IN_ENTRY = 0;
	public static final int INDEX_OF_PRODUCT_PRICE = 1;
	public static final int INDEX_OF_PRODUCT_NUMBER = 2;

	private Constants() throws InstantiationException {
		throw new InstantiationException();
	}
}
