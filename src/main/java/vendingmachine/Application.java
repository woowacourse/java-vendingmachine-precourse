package vendingmachine;

import java.util.List;

import vendingmachine.model.coin.Coins;
import vendingmachine.model.coin.CoinsGenerator;
import vendingmachine.model.item.Item;
import vendingmachine.model.item.ItemRepository;
import vendingmachine.model.machine.VendingMachine;
import vendingmachine.model.machine.VendingMachineRepository;
import vendingmachine.reader.ExchangeAmountReader;
import vendingmachine.reader.InputMoneyReader;
import vendingmachine.reader.ItemListReader;
import vendingmachine.view.PrintInitialExchangeCoinView;
import vendingmachine.view.PrintInputMoneyView;
import vendingmachine.view.PrintRemainInputMoneyCoinsView;

public class Application {
	public static void main(String[] args) {
		initVendingMachineApplication();
		VendingMachineController controller = new VendingMachineController();
		controller.run();
	}

	private static void initVendingMachineApplication() {
		VendingMachine vendingMachine = saveVendingMachineToRepository(createVendingMachine());
		vendingMachine.initExchangeCoins(generateCoins());
		saveItemsToRepository(inputItemLists());
		vendingMachine.inputMoney(inputMoney());
	}

	private static VendingMachine createVendingMachine() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.addObserver(new PrintInitialExchangeCoinView());
		vendingMachine.addObserver(new PrintInputMoneyView());
		vendingMachine.addObserver(new PrintRemainInputMoneyCoinsView());
		return vendingMachine;
	}

	private static VendingMachine saveVendingMachineToRepository(VendingMachine vendingMachine) {
		return VendingMachineRepository.save(vendingMachine);
	}

	private static Coins generateCoins() {
		return new CoinsGenerator().generate(ExchangeAmountReader.recursiveReader().read());
	}

	private static List<Item> inputItemLists() {
		return ItemListReader.recursiveReader().read();
	}

	private static void saveItemsToRepository(List<Item> items) {
		ItemRepository.saveAll(items);
	}

	private static int inputMoney() {
		return InputMoneyReader.recursiveReader().read();
	}
}
