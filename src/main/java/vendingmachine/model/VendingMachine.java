package vendingmachine.model;

import java.util.List;
import java.util.Map;

import vendingmachine.Coin;

public class VendingMachine {
	int change;
	int inputMoney;
	List<Product> productList;
	Map<Coin, Integer> coinIntegerMap;
}
