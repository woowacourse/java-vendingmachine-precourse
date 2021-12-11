package vendingmachine.models;

import java.util.ArrayList;
import java.util.HashMap;

import vendingmachine.utils.CoinTypeAmountGenerator;

/**
 * <h1>자판기 관련 데이터</h1>
 * 자판기를 가동하기 위해 필요한 모든 데이터를 관리한다
 *
 * @author yunki kim
 * @version 1.0
 * @since 2021-12-11
 */

public class VendingMachine {

	private static final Integer INITIAL_USER_INPUTTED_MONEY = 0;

	private final HashMap<Integer, Integer> coinTypesAmount;

	private ArrayList<Product> products;

	private int userInputtedMoney;

	public VendingMachine(final HashMap<Integer, Integer> coinTypesAmount, final ArrayList<Product> products) {
		this.coinTypesAmount = coinTypesAmount;
		this.products = products;
		this.userInputtedMoney = INITIAL_USER_INPUTTED_MONEY;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public int getUserInputtedMoney() {
		return userInputtedMoney;
	}

	public HashMap<Integer, Integer> getCoinTypesAmount() {
		return coinTypesAmount;
	}

	public void setProducts(final ArrayList<Product> products) {
		this.products = products;
	}

	public void setUserInputtedMoney(final int userInputtedMoney) {
		if(userInputtedMoney < 0) {
			return;
		}
		this.userInputtedMoney = userInputtedMoney;
	}
}
