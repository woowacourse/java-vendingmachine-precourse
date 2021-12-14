package vendingmachine.controller;

public interface GoodsStackerInterface {
	boolean stackGoods(String userGoodsAndPriceInput);
	int alignGoods();
}
