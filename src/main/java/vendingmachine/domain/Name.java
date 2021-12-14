package vendingmachine.domain;

import vendingmachine.utils.ErrorMessage;

public class Name {
	private final String name;

	public Name(String name) {
		validateEmptyMerchandiseName(name);
		this.name = name;
	}

	public boolean isSameName(String anotherName) {
		return name.equals(anotherName);
	}

	public static void validateEmptyMerchandiseName(String merchandiseName) {
		if (merchandiseName.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MERCHANDISE_EMPTY_NAME_ERROR_MESSAGE);
		}
	}
}
