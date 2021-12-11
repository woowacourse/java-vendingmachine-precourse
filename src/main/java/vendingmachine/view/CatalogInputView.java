package vendingmachine.view;

public class CatalogInputView {
	private static final String INPUT_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";

	public static void printInputGuide() {
		System.out.println(INPUT_MESSAGE);
	}
}
