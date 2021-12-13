package vendingmachine.validation;

public class IntegerDividableException implements Validation<Integer> {

	private static final String FORMAT = "%s '%d'는 %d로 나누어 떨어져야 합니다.";
	private int div;

	public IntegerDividableException(int div) {
		this.div = div;
	}

	@Override
	public void validate(Integer target, String name) throws IllegalArgumentException {
		if (target % div != 0) {
			throw new IllegalArgumentException(String.format(FORMAT, name, target, div));
		}
	}
}
