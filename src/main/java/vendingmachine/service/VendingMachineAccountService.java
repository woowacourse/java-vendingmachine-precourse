package vendingmachine.service;

import static vendingmachine.domain.Coin.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachineAccount;
import vendingmachine.view.ErrorMessage;

public class VendingMachineAccountService {
	public static final int INVALID_INPUT = -1;

	private static final VendingMachineAccount vendingMachineAccount = new VendingMachineAccount();

	public static void setRandomCoins() {
		int account = vendingMachineAccount.getAccount();
		for (Coin coin : Coin.values()) {
			int randomCount = getRandomCount(account, coin.getAmount());
			account -= randomCount * coin.getAmount();
			vendingMachineAccount.addCoinCount(coin, randomCount);
		}
	}

	private static int getRandomCount(int remainAmount, int coinUnit) {
		int min = 0;
		int max = remainAmount / coinUnit;
		if (coinUnit == COIN_10.getAmount()) {
			min = max;
		}
		return Randoms.pickNumberInRange(min, max);
	}

	public static int getValidInput() {
		try {
			String stringInput = Console.readLine();
			int input = InputExceptionService.parseToInt(stringInput);
			InputExceptionService.checkZeroOrPositiveInt(input);
			InputExceptionService.checkModTen(input);
			return input;
		} catch (IllegalArgumentException e) {
			ErrorMessage.print(e.getMessage());
			return INVALID_INPUT;
		}
	}

	public static void setAccountByInput() {
		int machineAccount = INVALID_INPUT;
		while (machineAccount == INVALID_INPUT) {
			machineAccount = VendingMachineAccountService.getValidInput();
		}
		vendingMachineAccount.setAccount(machineAccount);
	}
}
