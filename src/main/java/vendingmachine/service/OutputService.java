package vendingmachine.service;

import static vendingmachine.NumberConstant.*;

import vendingmachine.repository.CoinRepository;

public class OutputService {

	private static final CoinRepository coinRepository = new CoinRepository();

	private static final String WON = "원";
	private static final String STICK = " - ";
	private static final String UNIT = "개";

	public void printAllCoinCount() {
		System.out.println(FIVE_HUNDRED + WON + STICK + coinRepository.getCoinCount(FIVE_HUNDRED) + UNIT);
		System.out.println(HUNDRED + WON + STICK + coinRepository.getCoinCount(HUNDRED) + UNIT);
		System.out.println(FIFTY + WON + STICK + coinRepository.getCoinCount(FIFTY) + UNIT);
		System.out.println(TEN + WON + STICK + coinRepository.getCoinCount(TEN) + UNIT);
	}
}
