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
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name other = (Name)o;
		return Objects.equals(name, other.name);
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
