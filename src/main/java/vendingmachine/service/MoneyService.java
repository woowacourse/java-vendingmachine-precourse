package vendingmachine.service;

import vendingmachine.service.validator.MoneyInputValidator;
import vendingmachine.view.InputView;

public class MoneyService {

	private InputView inputView;
	private MoneyInputValidator moneyInputValidator;

	public MoneyService() {
		inputView = new InputView();
		moneyInputValidator = new MoneyInputValidator();
	}

	public int getSavedMoney(){
		String savedMoneyString;
		boolean isValidMoney;
		do {
			savedMoneyString = inputView.inputSavedMoney();
			isValidMoney = moneyInputValidator.validateSavedMoneyInput(savedMoneyString);
		}while(!isValidMoney);
		return Integer.parseInt(savedMoneyString);
	}

	public int getCustomerMoney() {
		String customerMoneyString;
		boolean isValidMoney;
		do {
			customerMoneyString = inputView.inputSavedMoney();
			isValidMoney = moneyInputValidator.validateCustomerMoneyInput(customerMoneyString);
		}while(!isValidMoney);
		return Integer.parseInt(customerMoneyString);
	}
}
