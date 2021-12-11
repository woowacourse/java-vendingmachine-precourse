package vendingmachine.domain;

import static vendingmachine.utils.StringValidator.*;

import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.menu.Menu;
import vendingmachine.domain.menu.Menus;

public class VendingMachine {
	private static final String ERROR_INPUT_MONEY_NUMBER = "[ERROR] 투입 금액은 정수입니다.";

	private Coins leftCoins;
	private Menus menus;
	private int inputMoney;

	public VendingMachine(Coins leftCoins, Menus menus) {
		this.leftCoins = leftCoins;
		this.menus = menus;
		this.inputMoney = 0;
	}

	public void putMoney(String money) {
		validateMoney(money);
		inputMoney = Integer.parseInt(money);
	}

	private void validateMoney(String money) {
		validateNumber(money, ERROR_INPUT_MONEY_NUMBER);
	}

	public void buy(String menuName) {
		Menu menu = menus.findMenuByName(menuName);
		if (isLessThanInputMoney(menu)) {
			useInputMoney(menu);
			menu.sold();
		}
	}

	private void useInputMoney(Menu menu) {
		inputMoney -= menu.getPrice();
	}

	private boolean isLessThanInputMoney(Menu menu) {
		return menu.getPrice() <= inputMoney;
	}

	public boolean canBuy() {
		return menus.isAnyMenuLeft() && isInputMoneyGreaterThanOrEqualToMinMenuPrice();
	}

	private boolean isInputMoneyGreaterThanOrEqualToMinMenuPrice() {
		return inputMoney >= menus.getMinMenuPrice();
	}

	public int getInputMoney() {
		return inputMoney;
	}

	public Coins getLeftCoins() {
		return leftCoins;
	}

}

