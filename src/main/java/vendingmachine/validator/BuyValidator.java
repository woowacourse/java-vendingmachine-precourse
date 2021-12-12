package vendingmachine.validator;

import static vendingmachine.validator.NameValidator.*;

import vendingmachine.model.Products;
import vendingmachine.model.VendingMachine;

public class BuyValidator {

	public static boolean isAvailableForBuy(String input, VendingMachine vendingMachine) {
		checkProductName(input);
		checkProductAvailability(input, vendingMachine.getProductList());
		checkRemainingDeposit(input, vendingMachine.getProductList(), vendingMachine.getDeposit());
		return true;
	}

	private static void checkProductAvailability(String productName, Products products) {
		if (!products.isExistProduct(productName)) {
			throw new IllegalArgumentException("상품이 존재하지 않습니다.");
		}

		if (!products.isQuantitySufficient(productName)) {
			throw new IllegalArgumentException("상품이 매진되었습니다.");
		}
	}

	private static void checkRemainingDeposit(String productName, Products products, int deposit) {
		if (products.isTooExpensive(productName, deposit)) {
			throw new IllegalArgumentException("상품이 남은 금액보다 비쌉니다.");
		}
	}

}
