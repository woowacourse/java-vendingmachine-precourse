package vendingmachine.view.classes;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.constant.ExceptionConstant.*;
import static vendingmachine.constant.PromptConstant.*;

import java.util.HashMap;

import vendingmachine.constant.VendingMachineStatus;
import vendingmachine.controller.CoinGeneratorInterface;
import vendingmachine.controller.GoodsStackerInterface;
import vendingmachine.controller.classes.CoinGenerator;
import vendingmachine.controller.classes.GoodsStacker;
import vendingmachine.exception.GoodsCountInvalidException;
import vendingmachine.exception.GoodsPriceInvalidException;
import vendingmachine.exception.InvalidUserInputException;
import vendingmachine.exception.NegativeUserInputException;
import vendingmachine.exception.UserGoodsInvalidFormatException;
import vendingmachine.view.VendingMachine;

public class VendingMachineUI implements VendingMachine {

	private VendingMachineStatus vendingMachineStatus = VendingMachineStatus.INPUT_MONEY_IN_VENDING_MACHINE;
	private int moneyInVendingMachine = 0;
	private PrintHandler printHandler = new PrintHandler();
	private GoodsStackerInterface goodsStackerInterface = new GoodsStacker();

	@Override
	public void start() {
		while (true) {
			configureVendingMachine();
			if (vendingMachineStatus == VendingMachineStatus.INPUT_USER_MONEY) {
				System.out.println(PROMPT_USER_INSERT_MONEY);
				String userInput = readLine();
				boolean isValidInput = userInput.matches(NUMBER_REGEX);
				try {
					if (!isValidInput) {
						throw new InvalidUserInputException();
					}
				} catch (InvalidUserInputException exception) {

				}

				if (isValidInput) {
					int userAmount = Integer.parseInt(userInput);
					if (!goodsStackerInterface.isEnoughMoney()) {
						vendingMachineStatus = VendingMachineStatus.SHOW_LEFT_COIN;
					}
					goodsStackerInterface.setUserInputMoney(userAmount);
					vendingMachineStatus = VendingMachineStatus.SHOW_USER_LEFT_MONEY;
				}
			}
			if (vendingMachineStatus == VendingMachineStatus.SHOW_USER_LEFT_MONEY) {
				System.out.println(goodsStackerInterface.getLeftMoneyString());
				vendingMachineStatus = VendingMachineStatus.INPUT_USER_GOODS;
				if (!goodsStackerInterface.isEnoughMoney()) {
					vendingMachineStatus = VendingMachineStatus.SHOW_LEFT_COIN;
				}
			}
			if (vendingMachineStatus == VendingMachineStatus.INPUT_USER_GOODS) {
				System.out.println(PROMPT_USER_INPUT_GOODS);
				String userInputGoods = readLine();
				vendingMachineStatus = VendingMachineStatus.SHOW_USER_LEFT_MONEY;
				if (!goodsStackerInterface.buyGoods(userInputGoods)) {
					vendingMachineStatus = VendingMachineStatus.SHOW_LEFT_COIN;
				}
			}
			if (vendingMachineStatus == VendingMachineStatus.SHOW_LEFT_COIN) {
				System.out.println(CHANGE_STRING);
				break;
			}
		}
	}
	private void configureVendingMachine() {
		if (vendingMachineStatus == VendingMachineStatus.INPUT_MONEY_IN_VENDING_MACHINE) {
			proceedInputVendingMachineHavingMoney();
		}
		if (vendingMachineStatus == VendingMachineStatus.SHOW_COINS_IN_VENDING_MACHINE) {
			proceedShowCoinsInVendingMachine();
		}
		if (vendingMachineStatus == VendingMachineStatus.INPUT_GOODS_AND_PRICES_IN_VENDING_MACHINE) {
			proceedInputGoodsAndPricesInVendingMachine();
		}
	}

	private void proceedInputGoodsAndPricesInVendingMachine() {
		String goodsAndPricesString = inputUserGoodsAndPricesString();

		boolean isValidGoodsAndPriceFormat = isValidGoodsAndPriceFormat(goodsAndPricesString,
			goodsStackerInterface);
		int isOneGoodsValidInputFormat = getIsOneGoodsValidInputFormat(goodsStackerInterface);
		checkIfPossibleToUserPhaseLevel(isValidGoodsAndPriceFormat, isOneGoodsValidInputFormat);
	}

	private void checkIfPossibleToUserPhaseLevel(boolean isValidGoodsAndPriceFormat, int isOneGoodsValidInputFormat) {
		if (isValidGoodsAndPriceFormat && isOneGoodsValidInputFormat == ONE_GOODS_VALID) {
			vendingMachineStatus = VendingMachineStatus.INPUT_USER_MONEY;
		}
	}

	private int getIsOneGoodsValidInputFormat(GoodsStackerInterface goodsStackerInterface) {
		int isOneGoodsValidInputFormat = ONE_GOODS_VALID;
		try {
			isOneGoodsValidInputFormat = goodsStackerInterface.alignGoods();
			checkIfValidUserInputFormat(isOneGoodsValidInputFormat);
		} catch (IllegalArgumentException exception) {

		}
		return isOneGoodsValidInputFormat;
	}

	private void checkIfValidUserInputFormat(int isOneGoodsValidInputFormat) {
		if (isOneGoodsValidInputFormat == PRICE_INVALID) {
			throw new GoodsPriceInvalidException();
		}
		if (isOneGoodsValidInputFormat == COUNT_INVALID) {
			throw new GoodsCountInvalidException();
		}
	}

	private boolean isValidGoodsAndPriceFormat(String goodsAndPricesString,
		GoodsStackerInterface goodsStackerInterface) {
		boolean isValidGoodsAndPriceFormat = false;
		try {
			isValidGoodsAndPriceFormat = goodsStackerInterface.stackGoods(goodsAndPricesString);
			if (!isValidGoodsAndPriceFormat) {
				throw new UserGoodsInvalidFormatException();
			}
		} catch (UserGoodsInvalidFormatException exception) {

		}
		return isValidGoodsAndPriceFormat;
	}

	private String inputUserGoodsAndPricesString() {
		System.out.println(PROMPT_VENDING_MACHINE_GOODS_AND_PRICES);
		String goodsAndPricesString = readLine();
		return goodsAndPricesString;
	}

	private void proceedShowCoinsInVendingMachine() {
		System.out.println(PROMPT_VENDING_MACHINE_HAVE_COINS);
		CoinGeneratorInterface coinGeneratorInterface = new CoinGenerator();
		HashMap<Integer, Integer>tmpCoinMap = coinGeneratorInterface.getRandomCoins(moneyInVendingMachine);
		printHandler.printCoinStatus(tmpCoinMap);


		vendingMachineStatus = VendingMachineStatus.INPUT_GOODS_AND_PRICES_IN_VENDING_MACHINE;
	}

	private void proceedInputVendingMachineHavingMoney() {
		inputVendingMachineHavingMoney();
	}

	private void inputVendingMachineHavingMoney() {
		System.out.println(PROMPT_VENDING_MACHINE_HAVE_MONEY);
		if (inputVendingMachineMoney()) {
			checkIfNegative(moneyInVendingMachine);
		}
	}

	private boolean inputVendingMachineMoney() {
		String vendingMachineMoneyString = readLine();
		try {
			isNumber(vendingMachineMoneyString);
		} catch (InvalidUserInputException exception) {
			return false;
		}
		moneyInVendingMachine = Integer.parseInt(vendingMachineMoneyString);
		return true;
	}

	private void isNumber(String vendingMachineMoneyString) {
		if (!vendingMachineMoneyString.matches(NUMBER_REGEX)) {
			throw new InvalidUserInputException();
		}
	}

	private void printIllegalArgumentErrorMessage() {
		System.out.print(ILLEGAL_USER_INPUT_EXCEPTION_MESSAGE);
	}

	private void checkIfNegative(int vendingMachineMoney) {
		try {
			isNotNegative(vendingMachineMoney);
			vendingMachineStatus = VendingMachineStatus.SHOW_COINS_IN_VENDING_MACHINE;
		} catch (NegativeUserInputException exception) {

		}
	}

	private void isNotNegative(int vendingMachineMoney) {
		if (vendingMachineMoney <= 0) {
			throw new NegativeUserInputException();
		}
	}
}
