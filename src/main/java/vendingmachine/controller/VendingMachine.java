package vendingmachine.controller;

import static vendingmachine.view.InputView.*;

import vendingmachine.dto.RequestHoldingMoneyDto;
import vendingmachine.service.VendingMachineService;

public class VendingMachine {
	private final VendingMachineService vendingMachineService;

	public VendingMachine() {
		vendingMachineService = new VendingMachineService();
	}

	public void initHoldingMoney() {
		RequestHoldingMoneyDto requestHoldingMoneyDto = inputHoldingMoney();
		vendingMachineService.initCoinRepository(requestHoldingMoneyDto);
	}
}
