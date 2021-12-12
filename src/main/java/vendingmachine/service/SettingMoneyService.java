package vendingmachine.service;

import vendingmachine.util.NumberException;

public class SettingMoneyService {
	public static int setMoney(String moneyStr) {
		int money;
		money = NumberException.checkMoneyException(moneyStr);
		return money;
	}
}
