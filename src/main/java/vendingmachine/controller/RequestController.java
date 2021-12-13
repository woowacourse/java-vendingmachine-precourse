package vendingmachine.controller;

import vendingmachine.domain.Changes;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.service.ChangesService;
import vendingmachine.service.ProductsService;
import vendingmachine.view.ExceptionView;
import vendingmachine.view.InputView;

public class RequestController {
	public static VendingMachine requestVendingMachine() {
		Changes changes = requestChanges();
		Products products = requestProducts();
		return new VendingMachine(changes, products);
	}

	public static Changes requestChanges() {
		try {
			String request = InputView.requestChanges();
			return ChangesService.toChanges(request);
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
}
