package vendingmachine.model;

import java.util.LinkedList;
import java.util.List;

public class VendingMachine {

	Wallet wallet;
	List<Product> productList = new LinkedList<>();

	public VendingMachine() {
		wallet = new Wallet();
	}

}
