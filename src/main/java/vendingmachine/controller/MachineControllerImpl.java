package vendingmachine.controller;

import java.util.List;

import vendingmachine.dto.ProductDto;
import vendingmachine.exception.VendingMachineException;
import vendingmachine.service.MachineService;
import vendingmachine.view.input.InputView;
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
		outputView.printMessage("자판기가 보유하고 있는 금액을 입력해 주세요.");
		while (true) {
			try {
				int moneyOfMachine = inputView.requestMoneyOfMachine();
				machineService.fillWithCoins(moneyOfMachine);
				break;
			} catch (VendingMachineException ex) {
				outputView.printErrorMessage(ex.getMessage());
			}
		}
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
		outputView.printMessage("상품명과 가격, 수량을 입력해 주세요.");
		while (true) {
			try {
				List<ProductDto> productDtos = inputView.requestProductDtos();
				machineService.saveProducts(productDtos);
				break;
			} catch (VendingMachineException ex) {
				outputView.printErrorMessage(ex.getMessage());
			}
		}
		outputView.printEmptyNewLine();
	}

	@Override
	public void depositMoney() {
		outputView.printMessage("투입 금액을 입력해 주세요.");
		while (true) {
			try {
				int moneyOfUser = inputView.requestMoneyOfUser();
				machineService.depositMoneyOfUser(moneyOfUser);
				break;
			} catch (VendingMachineException ex) {
				outputView.printErrorMessage(ex.getMessage());
			}
		}
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
		outputView.printMessage("구매할 상품명을 입력해 주세요.");
		while (true) {
			try {
				String productName = inputView.requestProductName();
				machineService.purchaseProduct(productName);
				break;
			} catch (VendingMachineException ex) {
				outputView.printErrorMessage(ex.getMessage());
			}
		}
		outputView.printEmptyNewLine();
	}

	@Override
	public void refundMoneyOfUser() {
		showCurrentMoneyOfUser();
		machineService.refundChanges();
		showCoinsOfUser();
	}

	private void showCoinsOfUser() {
		List<String> coinsOfUser = machineService.getCoinsOfUser();
		outputView.printCoinsOfUser(coinsOfUser);
		outputView.printEmptyNewLine();
	}

}
