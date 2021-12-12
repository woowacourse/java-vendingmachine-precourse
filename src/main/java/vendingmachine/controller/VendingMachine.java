package vendingmachine.controller;

import static vendingmachine.view.InputView.*;

import vendingmachine.dto.RequestHoldingMoneyDto;

public class VendingMachine {
	public VendingMachine() {
	}

	public void initHoldingMoney() {
		RequestHoldingMoneyDto requestHoldingMoneyDto = inputHoldingMoney();
	}
}
