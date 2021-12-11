package vendingmachine.domain;

import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.menu.Menus;

public class VendingMachine {
	private static final String ERROR_NOT_INTEGER = "[ERROR] 보유 금액은 정수입니다.";
	private static final String ERROR_LT_MIN_PRICE_COIN = "[ERROR] 보유 금액은 10원 이상입니다.";
	private static final String ERROR_NOT_DIVISIBLE_BY_MIN_PRICE_COIN = "[ERROR] 보유 금액은 10원의 배수입니다.";

	private Coins leftCoins;
	private Menus menus;

	public VendingMachine(Coins leftCoins, Menus menus) {
		this.leftCoins = leftCoins;
		this.menus = menus;
	}

	public Coins getLeftCoins() {
		return leftCoins;
	}

}

