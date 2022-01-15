package vendingmachine.controller;

import vendingmachine.view.InputView;

public class VendingMachineController {
  
  private static final String INVALID_MONEY_TYPE_ERROR_MESSAGE = "[ERROR] 금액은 숫자를 입력해야 한다.";
  private VendingMachine vendingMachine;
  private User user;

  public void init() {
		intputVendingMahchineMoneyWithErrorHandling();

  }

	public void intputVendingMahchineMoneyWithErrorHandling() {
		try {
			vendingMachine = new VendingMachine(Integer.parseInt(InputView.inputVendingMachineMoney()));
		} catch (NumberFormatException numberFormatException) {
			System.out.println(INVALID_MONEY_`TYPE_ERROR_MESSAGE);
			intputVendingMahchineMoneyWithErrorHandling();
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			intputVendingMahchineMoneyWithErrorHandling();
		}
	}


}
