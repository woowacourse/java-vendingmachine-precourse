package vendingmachine.service;

import static vendingmachine.NumberConstant.*;

import java.util.Map;

import vendingmachine.domain.Coin;

public class OutputService {

	private static final CoinService coinService = new CoinService();

	private static final String MONEY_OF_VENDING_MACHINE = "자판기가 보유한 동전";
	public static final String WON = "원";
	private static final String STICK = " - ";
	private static final String UNIT = "개";
	private static final String CHANGE = "잔돈";

	public void printAllCoinCount() {
		System.out.println(MONEY_OF_VENDING_MACHINE);
		System.out.println(FIVE_HUNDRED + WON + STICK + coinService.getCoinCount(FIVE_HUNDRED) + UNIT);
		System.out.println(HUNDRED + WON + STICK + coinService.getCoinCount(HUNDRED) + UNIT);
		System.out.println(FIFTY + WON + STICK + coinService.getCoinCount(FIFTY) + UNIT);
		System.out.println(TEN + WON + STICK + coinService.getCoinCount(TEN) + UNIT);
	}

	public void printChange(Map<Coin, Integer> change) {
		System.out.println(CHANGE);
		if (change.get(Coin.COIN_500) > ZERO) {
			System.out.println(FIVE_HUNDRED + WON + STICK + change.get(Coin.COIN_500) + UNIT);
		}
		if (change.get(Coin.COIN_100) > ZERO) {
			System.out.println(HUNDRED + WON + STICK + change.get(Coin.COIN_100) + UNIT);
		}
		if (change.get(Coin.COIN_50) > ZERO) {
			System.out.println(FIFTY + WON + STICK + change.get(Coin.COIN_50) + UNIT);
		}
		if (change.get(Coin.COIN_10) > ZERO) {
			System.out.println(TEN + WON + STICK + change.get(Coin.COIN_10) + UNIT);
		}
	}

	public void enter() {
		System.out.println();
	}
}
