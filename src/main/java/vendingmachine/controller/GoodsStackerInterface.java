package vendingmachine.controller;

import java.util.HashMap;

public interface GoodsStackerInterface {
	boolean stackGoods(String userGoodsAndPriceInput);
	int alignGoods();
	void setUserInputMoney(int userInputMoney);

	String getLeftMoneyString();

	boolean buyGoods(String userInputGoods);

	boolean isEnoughMoney();

	boolean isEnoughMoney(String userInputGoods);

	void setCoinMap(HashMap<Integer, Integer> coinMap);

	boolean haveName(String userInputGoods);
}
