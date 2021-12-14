package vendingmachine;

import java.util.ArrayList;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.models.Coin;
import vendingmachine.utils.CoinTypeAmountGenerator;
import vendingmachine.utils.RandomGenerator;
import vendingmachine.view.VendingMachineInput;
import vendingmachine.view.VendingMachineOutput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
		final VendingMachineOutput vendingMachineOutput = new VendingMachineOutput();
		final VendingMachineInput vendingMachineInput =
			new VendingMachineInput(new ArrayList<>());
		final ArrayList<Integer> coinTypes = new ArrayList<>();
		coinTypes.add(Coin.COIN_500.getAmount());
		coinTypes.add(Coin.COIN_100.getAmount());
		coinTypes.add(Coin.COIN_50.getAmount());
		coinTypes.add(Coin.COIN_10.getAmount());
		final CoinTypeAmountGenerator coinTypeAmountGenerator =
			new CoinTypeAmountGenerator(new RandomGenerator(), coinTypes);
		VendingMachineController vendingMachineController =
			new VendingMachineController(vendingMachineOutput,
				vendingMachineInput, coinTypeAmountGenerator);
		vendingMachineController.turnOn();
    }
}
