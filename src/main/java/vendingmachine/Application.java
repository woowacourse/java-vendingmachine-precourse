package vendingmachine;

import java.util.ArrayList;

import vendingmachine.controller.VendingMachineController;

import vendingmachine.utils.CoinTypeAmountGenerator;
import vendingmachine.utils.CoinTypeGenerator;
import vendingmachine.utils.RandomGenerator;

import vendingmachine.view.VendingMachineInput;
import vendingmachine.view.VendingMachineOutput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
		final VendingMachineOutput vendingMachineOutput = new VendingMachineOutput();
		final VendingMachineInput vendingMachineInput =
			new VendingMachineInput(new ArrayList<>());
		final ArrayList<Integer> coinTypes = CoinTypeGenerator.getCoinTypes();
		final CoinTypeAmountGenerator coinTypeAmountGenerator =
			new CoinTypeAmountGenerator(new RandomGenerator(), coinTypes);
		VendingMachineController vendingMachineController =
			new VendingMachineController(vendingMachineOutput,
				vendingMachineInput, coinTypeAmountGenerator);
		// vendingMachineController.turnOn();
    }
}
