package vendingmachine.view;

public class ItemMessage {
	public static final String ENTER_ITEM_FORM = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String ENTER_PURCHASE_ITEM_NAME = "구매할 상품명을 입력해 주세요.";

	public static void printSettingMessage() {
		System.out.println(ENTER_ITEM_FORM);
	}

	public static void printWhatToBuyMessage() {
		System.out.println(ENTER_PURCHASE_ITEM_NAME);
	}
}
