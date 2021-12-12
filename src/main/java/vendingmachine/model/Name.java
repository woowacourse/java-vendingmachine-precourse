package vendingmachine.model;

import java.util.Objects;

import vendingmachine.util.StringChecker;

public class Name {

	private String name;

	public Name(String input) {
		checkInput(input);
		name = input;
	}

	private void checkInput(String input) {
		StringChecker stringChecker = new StringChecker();
		stringChecker.isEmpty(input);
		stringChecker.containSpace(input);
		stringChecker.containTap(input);
	}

	public String get() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Name other = (Name)obj;
		if (!name.equals(other.name)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name);
	}
}
