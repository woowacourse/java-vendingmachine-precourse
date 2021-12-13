package vendingmachine.domain;

import vendingmachine.utils.Validator;

public class Name {
	private final String name;

	public Name(String name) {
		Validator.validateEmptyMerchandiseName(name);
		this.name = name;
	}

	public boolean isSameName(String anotherName) {
		return name.equals(anotherName);
	}
}
