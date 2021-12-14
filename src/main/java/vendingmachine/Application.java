package vendingmachine;

import java.util.List;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Item;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
	public static void main(String[] args) {
		Operation operation = new Operation();
		operation.operate();
	}
}
