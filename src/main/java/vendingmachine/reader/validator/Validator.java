package vendingmachine.reader.validator;

public interface Validator {
	boolean validate(String value);

	String getErrorMessage(String value, String inputValueName);
}
