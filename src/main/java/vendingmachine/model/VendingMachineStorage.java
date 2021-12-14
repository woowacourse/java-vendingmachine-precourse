package vendingmachine.model;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineStorage {
	private List<Goods> goodsList = new ArrayList<>();
	private int userInputMoney = 0;
	private int minAmount = 987654321;

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
		setminAmount(goodsList);
	}

	private void setminAmount(List<Goods> goodsList) {
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
}
