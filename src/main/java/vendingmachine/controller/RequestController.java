package vendingmachine.controller;

import vendingmachine.domain.Changes;
import vendingmachine.service.ChangesService;
import vendingmachine.view.ExceptionView;
import vendingmachine.view.InputView;

public class RequestController {
	public static Changes requestChanges() {
		try {
			String request = InputView.requestChanges();
			return ChangesService.toChanges(request);
		} catch (IllegalArgumentException e) {
			ExceptionView.errorUI(e.getMessage());
			return requestChanges();
		}
	}
}
