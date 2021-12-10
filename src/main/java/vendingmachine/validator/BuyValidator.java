package vendingmachine.validator;

import static vendingmachine.validator.ProductValidator.*;

import vendingmachine.model.ProductList;
import vendingmachine.model.VendingMachine;

// TODO: 2021/12/11 더 좋은 이름
public class BuyValidator {

	public static boolean isAvailableForBuy(String input, VendingMachine vendingMachine) {
		checkProductName(input);
		checkProductAvailability(input, vendingMachine.getProductList());
		checkRemainingDeposit(input, vendingMachine.getProductList(), vendingMachine.getDeposit());
		return true;
	}

	private static void checkProductAvailability(String productName, ProductList productList) {
		if (!productList.isExistProduct(productName)) {
			throw new IllegalArgumentException("상품이 존재하지 않습니다.");
		}

		if (!productList.isQuantitySufficient(productName)) {
			throw new IllegalArgumentException("상품이 매진되었습니다.");
		}
	}

	private static void checkRemainingDeposit(String productName, ProductList productList, int deposit) {
		if (productList.isTooExpensive(productName, deposit)) {
			throw new IllegalArgumentException("상품이 남은 금액보다 비쌉니다.");
		}
	}

}
