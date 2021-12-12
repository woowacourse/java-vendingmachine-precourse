package vendingmachine.domain;

import static vendingmachine.utils.StringValidator.*;

import java.util.Map;
import java.util.TreeMap;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.CoinMapComparator;
import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.menu.Menu;
import vendingmachine.domain.menu.Menus;

public class VendingMachine {
	private static final String ERROR_INPUT_MONEY_NUMBER = "투입 금액은 정수입니다.";
	private static final String ERROR_MENU_PRICE_GREATER_THAN_INPUT_MONEY = "투입 금액 이하의 메뉴를 선택해주세요.";

	private Coins leftCoins;
	private Menus menus;
	private int inputMoney;

	public VendingMachine(Coins leftCoins, Menus menus) {
		this.leftCoins = leftCoins;
		this.menus = menus;
		this.inputMoney = 0;
	}

	public int getInputMoney() {
		return inputMoney;
	}

	public void putMoney(String money) {
		validateInputMoney(money);
		inputMoney += Integer.parseInt(money);
	}

	private void validateInputMoney(String money) {
		validateNumber(money, ERROR_INPUT_MONEY_NUMBER);
	}

	public Coins returnChanges() {
		Map<Coin, Integer> coinMap = new TreeMap<>(new CoinMapComparator());
		while (leftCoins.hasCoinCheaperThanOrEqualToValue(inputMoney)) {
			Coin coin = leftCoins.popMaxPriceCoinCheaperThanOrEqualToValue(inputMoney);
			coinMap.put(coin, coinMap.getOrDefault(coin, 0) + 1);

			inputMoney -= coin.getAmount();
		}

		return new Coins(coinMap);
	}

	public void buy(String menuName) {
		Menu menu = menus.findMenuByName(menuName);
		validateMenuPrice(menu);

		useInputMoney(menu);
		menu.sold();
	}

	private void validateMenuPrice(Menu menu) {
		if (!isLessThanInputMoney(menu)) {
			throw new IllegalArgumentException(ERROR_MENU_PRICE_GREATER_THAN_INPUT_MONEY);
		}
	}

	private boolean isLessThanInputMoney(Menu menu) {
		return menu.getPrice() <= inputMoney;
	}

	private void useInputMoney(Menu menu) {
		inputMoney -= menu.getPrice();
	}

	public boolean canBuy() {
		return !menus.isEveryMenuSoldOut() && isInputMoneyGreaterThanOrEqualToMinMenuPrice();
	}

	private boolean isInputMoneyGreaterThanOrEqualToMinMenuPrice() {
		return inputMoney >= menus.getMinMenuPrice();
	}
}

