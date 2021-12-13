package vendingmachine.controller;

import vendingmachine.domain.Changes;
import vendingmachine.domain.Money;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.service.ChangesService;
import vendingmachine.service.MoneyService;
import vendingmachine.service.ProductsService;
import vendingmachine.utils.validator.RequestValidator;
import vendingmachine.view.ExceptionView;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class RequestController {
	public static Changes requestChanges() {
		try {
			String request = InputView.requestChanges();
			Changes changes = ChangesService.toChanges(request);
			OutputView.vendingMachineChanges(changes);
			return changes;
		} catch (IllegalArgumentException e) {
			ExceptionView.errorUI(e.getMessage());
			return requestChanges();
		}
	}

	public static Products requestProducts() {
		try {
			String request = InputView.requestProducts();
			return ProductsService.toProducts(request);
		} catch (IllegalArgumentException e) {
			ExceptionView.errorUI(e.getMessage());
			return requestProducts();
		}
	}

	public static Money requestInsertMoney() {
		try {
			String request = InputView.requestInsertMoney();
			return MoneyService.toMoney(request);
		} catch (IllegalArgumentException e) {
			ExceptionView.errorUI(e.getMessage());
			return requestInsertMoney();
		}
	}

	public static String requestProductName() {
		try {
			String request = InputView.requestProductName();
			RequestValidator.isEmpty(request);
			return request;
		} catch (IllegalArgumentException e) {
			ExceptionView.errorUI(e.getMessage());
			return requestProductName();
		}
	}
}
