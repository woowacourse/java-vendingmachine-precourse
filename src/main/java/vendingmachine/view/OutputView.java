package vendingmachine.view;

import vendingmachine.domain.Coins;

public class OutputView {
	private static final String VENDING_MACHINE_OF_COIN_INSTRUCTION = "자판기가 보유한 동전 ";
	private static final String MONEY_TO_COUNT_MAPPER = " - ";
	private static final String UNIT_OF_COIN_COUNT = "개";
	private static final String UNIT_OF_MONEY = "원";
	private static final String INPUT_MONEY_OF_VENDING_MACHINE_INSTRUCTION = "투입 금액: ";
	private static final String LEFTOVER_MONEY_OF_VENDING_MACHINE_INSTRUCTION = "잔돈 ";


	public void printVeningMachineCoin(Coins coinCountMap) {
		System.out.println(VENDING_MACHINE_OF_COIN_INSTRUCTION);
		coinCountMap.getCoinCount().forEach((key, value) -> {
			printCoinInformation(key.getAmount(), value);
		});
		System.out.println();
	}

	public void printMoneyInputToVendingMachine(int inputMoney) {
		System.out.println();
		System.out.println(INPUT_MONEY_OF_VENDING_MACHINE_INSTRUCTION + inputMoney + UNIT_OF_MONEY);
	}

	public void printLeftoverCoinCount(Coins coinCountMap) {
		System.out.println(LEFTOVER_MONEY_OF_VENDING_MACHINE_INSTRUCTION);
		coinCountMap.getCoinCount().forEach((key, value) -> {
			if (value != 0) {
				printCoinInformation(key.getAmount(), value);
			}
		});
		System.out.println();
	}

	public void printMessage(String message) {
		System.out.println(message);
	}

	private void printCoinInformation(int coinAmount, int coinCount) {
		System.out.println(coinAmount + UNIT_OF_MONEY + MONEY_TO_COUNT_MAPPER + coinCount + UNIT_OF_COIN_COUNT);
	}
}
