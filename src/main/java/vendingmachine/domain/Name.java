package vendingmachine.domain;

import java.util.Objects;

import vendingmachine.validation.StringExistValidation;
import vendingmachine.validation.Validator;

public class Name {
	private static final String NAME = "이름";
	private String name;

	public Name(String name) {
		Validator.validate(NAME, name, new StringExistValidation());
		this.name = name;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		Name otherName = (Name)other;
		return Objects.equals(name, otherName.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return name;
	}
}
