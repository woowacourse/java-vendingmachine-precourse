package vendingmachine.domain;

public class Name {
	private static final String INVALID_MERCHANDISE_EMPTY_NAME_ERROR_MESSAGE = "[ERROR] 상품명은 최소 1글자여야 한다.";

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
			throw new IllegalArgumentException(INVALID_MERCHANDISE_EMPTY_NAME_ERROR_MESSAGE);
		}
	}
}
