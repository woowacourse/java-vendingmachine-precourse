package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.exception.dto.ErrorResponse;
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

		try{
			ResponseMessage.of('\n'+vendingMachineService.postVendingMachineCosts(Console.readLine()));
		} catch(IllegalArgumentException e){
			ErrorResponse.of(e.getMessage());
			postVendingMachineCosts();
		}
	}

	public void postProductInfo(){
	}

	public void postInputCosts(){

	}

	public void postProductName(){

	}

	public void getBalance(){

	}
}
