package vendingmachine.validation;

public class IntegerGreaterValidation implements Validation<Integer> {

	private static final String FORMAT = "%s 은 %d 이상이어야 합니다.(입력 : %d)";

	private int min;

	public IntegerGreaterValidation(int min) {
		this.min = min;
	}

	@Override
	public void validate(Integer target, String name) throws IllegalArgumentException {
		if (target < min) {
			throw new IllegalArgumentException(String.format(FORMAT, name, min, target));
		}
	}
}
