package vendingmachine.domain;

import java.util.HashMap;
import java.util.List;

public class VendingMachine {
	public int holdingMoney;
	public int inputMoney;
	public List<Item> itemList;
	public HashMap<Coin,Integer> coinCount;
}
