package vendingmachine;

import vendingmachine.model.coin.Coins;
import vendingmachine.model.coin.CoinsGenerator;
import vendingmachine.model.item.ItemRepository;
import vendingmachine.model.machine.VendingMachine;
import vendingmachine.model.machine.VendingMachineRepository;
import vendingmachine.reader.ExchangeAmountReader;
import vendingmachine.reader.InputMoneyReader;
import vendingmachine.reader.ItemListReader;

public class Application {
	public static void main(String[] args) {
		VendingMachineController controller = createVendingMachineController();
		controller.run();
	}

	private static VendingMachineController createVendingMachineController() {
		Coins coins = generateCoins();
		saveItemsToRepository();
		int inputMoney = inputMoney();
		saveVendingMachineToRepository(coins, inputMoney);
		return new VendingMachineController();
	}

	private static Coins generateCoins() {
		Coins coins = new CoinsGenerator().generate(ExchangeAmountReader.recursiveReader().read());
		System.out.println("자판기가 보유한 동전");
		coins.stream().forEach(coin -> System.out.println(coin.getAmount() + "원 - " + coins.getCount(coin) + "개"));
		return coins;
	}

	private static void saveItemsToRepository() {
		ItemRepository.saveAll(ItemListReader.recursiveReader().read());
	}

	private static int inputMoney() {
		int inputMoney = InputMoneyReader.recursiveReader().read();
		return inputMoney;
	}

	private static void saveVendingMachineToRepository(Coins coins, int inputMoney) {
		VendingMachineRepository.save(new VendingMachine(coins, inputMoney));
	}
}
