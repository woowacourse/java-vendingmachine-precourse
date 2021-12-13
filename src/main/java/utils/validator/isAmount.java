package utils.validator;

public class isAmount implements Validator{
	public boolean run(StringBuilder input) {
		new isDigit().run(input);
		if (isNegative(input)) {
			throw new IllegalArgumentException("[ERROR] 음수단위의 금액은 사용할 수 없습니다.");
		}
		return true;
	}

	private boolean isNegative(StringBuilder input) {
		int amount = Integer.parseInt(input.toString());
		return amount <= 0;
	}
}
