package vendingmachine.view;

public class Print {
	private static final String INSERT_MONEY_OF_CHANGES = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String COUNT_OF_COINS_TITLE = "자판기가 보유한 동전";
	private static final String MONEY_UNIT = "원";
	private static final String COIN_UNIT = "개";
	private static final String COIN_AND_COUNT_SPLIT_SYMBOL = " - ";

	private static final String INSERT_PRODUCTS = "상품명과 가격, 수량을 입력해 주세요.";

	// TODO: 사용하지 않는 메소드 및 상수 삭제
	private static final String PRODUCT_NOT_SAVE = "해당 	상품의 정보가 올바르지 않아 등록되지 않았습니다 : ";
	private static final String PRODUCT_DUPLICATE = "해당 상품의 이름이 이전에 등록된 상품의 이름과 동일하여 등록되지 않았습니다 : ";

	private static final String INSERT_MONEY = "투입 금액을 입력해 주세요.";
	private static final String REMAIN_MONEY = "투입 금액: ";

	private static final String SELECT_PRODUCT = "구매할 상품명을 입력해 주세요.";

	public static void printErrorMessage(Exception e) {
		System.out.println(e.getMessage());
	}

	public static void printNotice(String notice) {
		System.out.println(notice);
	}

	public static void printInsertMoneyOfChanges() {
		System.out.println(INSERT_MONEY_OF_CHANGES);
	}

	public static void printCountOfCoinsTitle() {
		System.out.println();
		System.out.println(COUNT_OF_COINS_TITLE);
	}

	public static void printCountOfCoins(int amount, int count) {
		System.out.println(amount + MONEY_UNIT + COIN_AND_COUNT_SPLIT_SYMBOL + count + COIN_UNIT);
	}

	public static void printInsertProducts() {
		System.out.println();
		System.out.println(INSERT_PRODUCTS);
	}

	public static void printProductNotSave(String name) {
		System.out.println(PRODUCT_NOT_SAVE + name);
	}

	public static void printDuplicatedProductName(String name) {
		System.out.println(PRODUCT_DUPLICATE + name);
	}

	public static void printInsertMoney() {
		System.out.println();
		System.out.println(INSERT_MONEY);
	}

	public static void printRemainMoney(int money) {
		System.out.println();
		System.out.println(REMAIN_MONEY + money + MONEY_UNIT);
	}

	public static void printSelectProduct() {
		System.out.println(SELECT_PRODUCT);
	}
}
