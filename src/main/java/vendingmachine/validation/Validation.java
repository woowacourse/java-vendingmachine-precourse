package vendingmachine.validation;

public interface Validation<T> {
	void validate(T target, String name);
}
