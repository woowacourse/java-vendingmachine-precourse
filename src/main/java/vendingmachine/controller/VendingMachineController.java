package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.message.Message;
import vendingmachine.message.dto.ResponseMessage;
import vendingmachine.service.VendingMachineService;

public class VendingMachineController {

	private VendingMachineService vendingMachineService;

	public VendingMachineController() {
		this.vendingMachineService = new VendingMachineService();
	}

	public void postVendingMachineCosts() {
		ResponseMessage.of(Message.ENTER_COSTS_GOING_TO_HAS_MACHINE.getMessage());
		vendingMachineService.postVendingMachineCosts(Console.readLine());
	}

	public void postProductInfo(){
		ResponseMessage.of(Message.PRINT_COIN_IN_MACHINE.getMessage());
	}

	public void postInputCosts(){

	}

	public void postProductName(){

	}

	public void getBalance(){

	}
}
