package vendingmachine;

public class PurchaseProductNameValidator {
	public PurchaseProductNameValidator() {
	}

	public boolean validate(String name, ProductTable table) {
		try {
			isZeroLength(name);
			isExistsInTable(name, table);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}

	private void isZeroLength(String name) throws IllegalArgumentException {
		if (name.trim().length() == 0) {
			throw new IllegalArgumentException(Error.ZERO_LENGTH_PURCHASE_PRODUCT_NAME.getMessage());
		}
	}

	private void isExistsInTable(String name, ProductTable table) throws IllegalArgumentException {
		if (!table.hasProductName(name)) {
			throw new IllegalArgumentException(Error.NO_MATCHED_ENTRY_PRODUCT_NAME.getMessage());
		}
	}
}
