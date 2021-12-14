package vendingmachine;

public class InputChecker {
	public static void checkNumber(String inputNumber) {
		for (int i = 0; i < inputNumber.length(); i++) {
			if (!Character.isDigit(inputNumber.charAt(i))) {
				throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
			}
		}
	}

	public static void checkProduct(String inputText) {
		if (!inputText.contains("[") || !inputText.contains("]")) {
			throw new IllegalArgumentException("[ERROR] 상품을 대괄호로 감싸세요.");
		}

		String[] splited = inputText.substring(1, inputText.length() - 1).split(",");
		for (int i = 0; i < splited.length; i++) {
			if (splited[i].isEmpty()) {
				throw new IllegalArgumentException("[ERROR] 상품 이름, 가격, 수량을 모두 입력하세요.");
			}
		}

		checkNumber(splited[1]);
		checkNumber(splited[2]);
	}
}
