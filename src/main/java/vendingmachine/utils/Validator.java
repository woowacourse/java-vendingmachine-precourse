package vendingmachine.utils;

import vendingmachine.domain.VendingMachine;

public class Validator {

	public static boolean isValidToBuyProduct(VendingMachine vendingMachine) {
		int currentInputMoney = vendingMachine.getInputMoney().getCurrentMoney();
		int minPriceProduct = vendingMachine.getProducts().getMinPriceProduct();
		return currentInputMoney >= minPriceProduct;
	}
}
