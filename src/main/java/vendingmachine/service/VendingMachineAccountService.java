package vendingmachine.service;

import static vendingmachine.controller.VendingMachineAccountController.*;
import static vendingmachine.domain.Coin.*;

import java.util.HashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.view.ErrorMessage;

public class VendingMachineAccountService {

	public static Map<Coin, Integer> setRandomCoins(int amount) {
		Map<Coin, Integer> coinCount = new HashMap<>();
		for (Coin coin : Coin.values()) {
			int randomCount = getRandomCount(amount, coin.getAmount());
			coinCount.put(coin, randomCount);
			amount -= randomCount * coin.getAmount();
		}
		return coinCount;
	}

	private static int getRandomCount(int remainAmount, int coinUnit) {
		int min = 0;
		int max = remainAmount / coinUnit;
		if (coinUnit == COIN_10.getAmount()) {
			min = max;
		}
		return Randoms.pickNumberInRange(min, max);
	}

	public static int validateInput(String stringInput) {
		try {
			int input = InputExceptionService.parseToInt(stringInput);
			InputExceptionService.checkZeroOrPositiveInt(input);
			InputExceptionService.checkModTen(input);
			return input;
		} catch (IllegalArgumentException e) {
			ErrorMessage.print(e.getMessage());
			return INVALID_INPUT;
		}

	}
}
