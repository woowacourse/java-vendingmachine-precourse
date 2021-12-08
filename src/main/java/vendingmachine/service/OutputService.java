package vendingmachine.service;

import static vendingmachine.NumberConstant.*;

public class OutputService {

	private static final CoinService coinService = new CoinService();

	private static final String MONEY_OF_VENDING_MACHINE = "자판기가 보유한 동전";
	private static final String WON = "원";
	private static final String STICK = " - ";
	private static final String UNIT = "개";

	public void printAllCoinCount() {
		System.out.println(MONEY_OF_VENDING_MACHINE);
		System.out.println(FIVE_HUNDRED + WON + STICK + coinService.getCoinCount(FIVE_HUNDRED) + UNIT);
		System.out.println(HUNDRED + WON + STICK + coinService.getCoinCount(HUNDRED) + UNIT);
		System.out.println(FIFTY + WON + STICK + coinService.getCoinCount(FIFTY) + UNIT);
		System.out.println(TEN + WON + STICK + coinService.getCoinCount(TEN) + UNIT);
	}

	public void enter() {
		System.out.println();
	}
}
