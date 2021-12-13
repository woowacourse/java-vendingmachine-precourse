package vendingmachine.domain;

import java.util.Objects;

public class Name {
	private final String name;

	private Name(String name) {
		this.name = name;
	}

	public static Name from(String name) {
		return new Name(name);
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Name))
			return false;
		Name name1 = (Name)o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
