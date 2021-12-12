package vendingmachine.service;

import java.util.List;

import vendingmachine.domain.Item;
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
			savedMoneyString = inputView.inputMoney();
			isValidMoney = moneyInputValidator.validateSavedMoneyInput(savedMoneyString);
		}while(!isValidMoney);
		return Integer.parseInt(savedMoneyString);
	}

	public int getCustomerMoney() {
		String customerMoneyString;
		boolean isValidMoney;
		do {
			customerMoneyString = inputView.inputMoney();
			isValidMoney = moneyInputValidator.validateCustomerMoneyInput(customerMoneyString);
		}while(!isValidMoney);
		return Integer.parseInt(customerMoneyString);
	}

	public boolean isEnoughMoneyForMinPriceItem(List<Item> items, int customerMoney) {
		return items.stream()
			.anyMatch(item -> item.isEnoughMoneyForPurchasing(customerMoney) == true);
	}
}
