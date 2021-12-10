package vendingmachine.domain.item;

import java.util.Objects;

import vendingmachine.validator.ItemValidator;

public class ItemName {
	private final String name;

	private ItemName(String name) {
		this.name = name;
	}

	public static ItemName from(String name) {
		ItemValidator.validateItemName(name);
		return new ItemName(name);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		ItemName itemName = (ItemName)object;
		return name.equals(itemName.name);
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
