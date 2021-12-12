package vendingmachine.controller;

import vendingmachine.service.UserAccountService;
import vendingmachine.view.UserAccountView;

public class UserAccountController {
	public static void setUserAccountByInput() {
		UserAccountView.printInputGuide();
		UserAccountService.setUserAccount();
	}
}
