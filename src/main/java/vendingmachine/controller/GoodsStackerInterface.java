package vendingmachine.controller;

public interface GoodsStackerInterface {
	boolean stackGoods(String userGoodsAndPriceInput);
	int alignGoods();
	void setUserInputMoney(int userInputMoney);

	String getLeftMoneyString();

	boolean buyGoods(String userInputGoods);

	boolean isEnoughMoney();
}
