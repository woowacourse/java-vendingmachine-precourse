package vendingmachine.controller;

import static vendingmachine.domain.Merchandises.*;
import static vendingmachine.domain.VendingMachine.*;

import vendingmachine.domain.Merchandises;
import vendingmachine.domain.User;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	private static final String INVALID_MONEY_TYPE_ERROR_MESSAGE = "[ERROR] 금액은 숫자를 입력해야 한다.";
	private VendingMachine vendingMachine;
	private User user;

	public void init() {
		inputVendingMachineMoneyWithErrorHandling();
		OutputView.showVendingMachineCoinStatus(castingCoinToInteger(vendingMachine.saveCoinStatus()));
		inputMerchandiseInfomationWithErrorHandling();
		inputMoneyWithErrorHandling();
		while (vendingMachine.isUserBuyMerchandise(user.getUserMoney())
				&& !vendingMachine.isSoldOutMerchandises()) {
			OutputView.showInputMoneyStatus(user.getUserMoney());
			buyMerchandiseWithErrorHandling();
		}

		OutputView.showChangeMoneyStatus(user.getUserMoney(),
				castingCoinToInteger(vendingMachine.changeCoinStatus(user.getUserMoney())));
	}

	public void inputVendingMachineMoneyWithErrorHandling() {
		try {
			vendingMachine = new VendingMachine(Integer.parseInt(InputView.inputVendingMachineMoney()));
		} catch (NumberFormatException numberFormatException) {
			System.out.println(INVALID_MONEY_TYPE_ERROR_MESSAGE);
			inputVendingMachineMoneyWithErrorHandling();
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			inputVendingMachineMoneyWithErrorHandling();
		}
	}

	private void inputMoneyWithErrorHandling() {
		try {
			user = new User(Integer.parseInt(InputView.inputMoney()));
		} catch (NumberFormatException numberFormatException) {
			System.out.println(INVALID_MONEY_TYPE_ERROR_MESSAGE);
			inputMoneyWithErrorHandling();
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			inputMoneyWithErrorHandling();
		}
	}

	private void inputMerchandiseInfomationWithErrorHandling() {
		try {
			vendingMachine.stockMerchandises(
					new Merchandises(constructMerchandises(InputView.inputMerchandiseInfomation())));
		} catch (NumberFormatException numberFormatException) {
			System.out.println(INVALID_MONEY_TYPE_ERROR_MESSAGE);
			inputMerchandiseInfomationWithErrorHandling();
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			inputMerchandiseInfomationWithErrorHandling();

		}

	}

	private void buyMerchandiseWithErrorHandling() {
		try {
			user.buyMerchandise(vendingMachine.sellMerchandise(InputView.inputMerchandiseName()));
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(user.getUserMoney());
			System.out.println(illegalArgumentException.getMessage());
			buyMerchandiseWithErrorHandling();
		}

	}


}
