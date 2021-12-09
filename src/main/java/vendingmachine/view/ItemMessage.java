package vendingmachine.view;

public class ItemMessage {
	public static final String ENTER_ITEM = "상품명과 가격, 수량을 입력해 주세요.";

	public static void printInputMessage() {
		System.out.println(ENTER_ITEM);
	}
}
