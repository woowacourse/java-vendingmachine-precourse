package vendingmachine.validation;

public class PositiveIntegerValidation implements Validation<Integer> {

	private static final String FORMAT = "%s 는(은) 0 미만이 될 수 없습니다.";

	@Override
	public void validate(Integer target, String name) throws IllegalArgumentException {
		if (target < 0) {
			throw new IllegalArgumentException(String.format(FORMAT, name));
		}
	}
}
