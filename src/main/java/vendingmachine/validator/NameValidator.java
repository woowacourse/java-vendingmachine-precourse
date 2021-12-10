package vendingmachine.validator;

public class NameValidator {

	private static final String KOREAN_REGEX = ".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*";

	public static void checkProductName(String productName) {
		if (!productName.matches(KOREAN_REGEX)) {
			throw new IllegalArgumentException("상품명은 한글만 허용됩니다.");
		}
	}

}
