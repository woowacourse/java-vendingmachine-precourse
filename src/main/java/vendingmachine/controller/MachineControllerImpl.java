package vendingmachine.controller;

import java.util.List;

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

	}

	@Override
	public void depositMoney() {
		int moneyOfUser = inputView.requestMoneyOfUser();
		machineService.depositMoneyOfUser(moneyOfUser);
		outputView.printEmptyNewLine();
	}

	@Override
	public void purchaseProducts() {

	}

}
