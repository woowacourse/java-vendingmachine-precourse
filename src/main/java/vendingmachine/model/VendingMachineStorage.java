package vendingmachine.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendingMachineStorage {
	private List<Goods> goodsList = new ArrayList<>();
	private HashMap<Integer, Integer> coinMap;
	private int userInputMoney = 0;
	private int minAmount = Integer.MAX_VALUE;

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
		setMinAmount(goodsList);
	}

	private void setMinAmount(List<Goods> goodsList) {
		for (Goods goods : goodsList) {
			if (goods.getPrice() < minAmount) {
				minAmount = goods.getPrice();
			}
		}
	}

	public int getUserInputMoney() {
		return userInputMoney;
	}

	public void setUserInputMoney(int userInputMoney) {
		this.userInputMoney = userInputMoney;
	}

	public int getMinAmount() {
		return minAmount;
	}

	public void setCoinMap(HashMap<Integer, Integer> coinMap) {
		this.coinMap = coinMap;
	}

	public boolean haveName(String userInputGoods) {
		for (Goods goods : goodsList) {
			if (goods.getName().equals(userInputGoods)) {
				return true;
			}
		}
		return false;
	}

	public HashMap<Integer, Integer> getCoinMap() {
		return coinMap;
	}
}
