package vendingmachine.view;

public class PurchaseView {
	private static final String PURCHASE_INPUT_GUIDE_MESSAGE = "구매할 상품명을 입력해 주세요.";

	public static void printGuide() {
		System.out.println(PURCHASE_INPUT_GUIDE_MESSAGE);
	}
}
