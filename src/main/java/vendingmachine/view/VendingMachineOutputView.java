package vendingmachine.view;

import static vendingmachine.constants.HostMessages.*;

import java.util.List;

import vendingmachine.resource.Coin;

public class VendingMachineOutputView {
	private static final VendingMachineOutputView vendingMachineOutputView = new VendingMachineOutputView();

	private VendingMachineOutputView() {
	}

	public static VendingMachineOutputView getVendingMachineOutputView(){
		return vendingMachineOutputView;
	}

	public void printAmountInputMessage(){
		System.out.println(VENDING_MACHINE_INITIAL_MONEY_INPUT_MESSAGE);
	}

	public void printVendingMachineInitialCoinsOutputMessage(){
		System.out.println(VENDING_MACHINE_INITIAL_COINS_OUTPUT_MESSAGE);
	}

	public void printVendingMachineInitialCoins(List<Integer> numberOfCoins){
		List<Integer> monetaryUnitList = Coin.getMonetaryUnitList();
		for (int i = 0; i < numberOfCoins.size(); i++) {
			System.out.println(monetaryUnitList.get(i) + "원 - " + numberOfCoins.get(i));
		}
		System.out.println();
	}
}
