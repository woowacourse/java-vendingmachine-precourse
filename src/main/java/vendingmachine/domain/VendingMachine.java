package vendingmachine.domain;

import static vendingmachine.utils.StringValidator.*;

import vendingmachine.domain.coin.Coins;
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

	public void validateMoney(String money) {
		validateNumber(money, ERROR_INPUT_MONEY_NUMBER);
	}

	public Coins getLeftCoins() {
		return leftCoins;
	}

}

