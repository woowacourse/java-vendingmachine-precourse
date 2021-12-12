package vendingmachine.validation;

public class Validator {

	public static <T> T validate(String name, T target, Validation<T> ... validations) {
		for (Validation<T> validation : validations) {
			validation.validate(target, name);
		}
		return target;
	}
}
