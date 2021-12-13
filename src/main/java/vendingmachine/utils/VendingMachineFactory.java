package vendingmachine.utils;

import java.util.List;
import vendingmachine.model.CoinCase;
import vendingmachine.model.Product;
import vendingmachine.model.VendingMachine;

public class VendingMachineFactory {

	private VendingMachineFactory() {
	}

	public static VendingMachine makeVendingMachine(CoinCase coinCases,
		List<Product> products, int insertMoney) {
		return new VendingMachine(coinCases, products, insertMoney);
	}
}
