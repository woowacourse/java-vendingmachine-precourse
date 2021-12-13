package vendingmachine.service;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachineAccount;
import vendingmachine.service.exception.InputExceptionService;
import vendingmachine.view.exception.ErrorMessage;

public class VendingMachineAccountService {
	public static final int INVALID_INPUT = -1;

	private static final VendingMachineAccount vendingMachineAccount = new VendingMachineAccount();

	public static void setRandomCoins() {
		int account = vendingMachineAccount.getAccount();

		while (account > 0) {
			int randomCoin = Randoms.pickNumberInList(Arrays.asList(500, 100, 50, 10));
			if (account < randomCoin) {
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
