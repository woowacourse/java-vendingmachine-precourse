package vendingmachine;

public class InputValidator {

	public static boolean validateNumber(String number){
		for (int i = 0; i < number.length(); i++) {
			if ((number.charAt(i) < '0') || (number.charAt(i) > '9')) {
				throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
			}
		}
		return true;
	}

	public static void validatePrice(int price){
		if(price < 100){
			throw new IllegalArgumentException("[ERROR] 상품 가격은 100원부터 시작해야 합니다.");
		}
		if(price % 10 != 0){
			throw new IllegalArgumentException("[ERROR] 상품 가격은 10원으로 나누어떨어져야 합니다.");
		}
	}
}
