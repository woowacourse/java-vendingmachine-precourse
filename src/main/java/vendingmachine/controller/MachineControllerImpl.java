package vendingmachine.controller;

import java.util.List;

import vendingmachine.dto.ProductDto;
import vendingmachine.service.MachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineControllerImpl implements MachineController {

	private MachineService machineService;
	private InputView inputView;
	private OutputView outputView;

	public MachineControllerImpl(MachineService machineService, InputView inputView, OutputView outputView) {
		this.machineService = machineService;
		this.inputView = inputView;
		this.outputView = outputView;
	}

	@Override
	public void fillWithCoins() {
		int moneyOfMachine = inputView.requestMoneyOfMachine();
		machineService.fillWithCoins(moneyOfMachine);
		outputView.printEmptyNewLine();
	}

	@Override
	public void showCoinsOfMachine() {
		List<String> coinsOfMachine = machineService.getCoinsOfMachine();
		outputView.printCoinsOfMachine(coinsOfMachine);
		outputView.printEmptyNewLine();
	}

	@Override
	public void registerProducts() {
		List<ProductDto> productDtos = inputView.requestProductDtos();
		machineService.saveProducts(productDtos);
	}

	@Override
	public void depositMoney() {
		int moneyOfUser = inputView.requestMoneyOfUser();
		machineService.depositMoneyOfUser(moneyOfUser);
		outputView.printEmptyNewLine();
	}

	@Override
	public void purchaseProducts() {
		while (machineService.isUserPossibleToUseMachine()) {
			showCurrentMoneyOfUser();
			purchaseProduct();
		}
	}

	private void showCurrentMoneyOfUser() {
		int currentMoneyOfUser = machineService.getCurrentMoneyOfUser();
		outputView.printCurrentMoneyOfUser(currentMoneyOfUser);
	}

	private void purchaseProduct() {
		String productName = inputView.requestProductName();
		machineService.purchaseProduct(productName);
		outputView.printEmptyNewLine();
	}

	@Override
	public void refundMoneyOfUser() {
		showCurrentMoneyOfUser();
		showCoinsOfUser();
	}

	private void showCoinsOfUser() {
		List<String> coinsOfUser = machineService.getCoinsOfUser();
		outputView.printCoinsOfUser(coinsOfUser);
		outputView.printEmptyNewLine();
	}

}
