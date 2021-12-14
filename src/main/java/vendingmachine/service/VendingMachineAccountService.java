package vendingmachine.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.repository.VendingMachineAccount;
import vendingmachine.service.exception.InputExceptionService;
import vendingmachine.view.exception.ErrorMessage;

public class VendingMachineAccountService {
	public static final int INVALID_INPUT = -1;
	private static final List<Integer> COIN_UNIT_LIST = Arrays.asList(500, 100, 50, 10);

	private static final VendingMachineAccount vendingMachineAccount = new VendingMachineAccount();

	public static void setRandomCoins() {
		int account = vendingMachineAccount.getAccount();
		List<Integer> coinUnit = new ArrayList<>(COIN_UNIT_LIST);
		while (account > 0) {
			Integer randomCoin = Randoms.pickNumberInList(coinUnit);
			if (randomCoin > account) {
				coinUnit.remove(randomCoin);
				continue;
			}
			account -= randomCoin;
			vendingMachineAccount.addCoinCount(Coin.valueOf(randomCoin));
		}
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
			machineAccount = getValidInput();
		}
		vendingMachineAccount.setAccount(machineAccount);
	}
}
