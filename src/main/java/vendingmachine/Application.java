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
	private static ItemRepository itemRepository;
	private static VendingMachineRepository vendingMachineRepository;

	public static void main(String[] args) {
		VendingMachineController controller = createVendingMachineController();
		controller.run();
	}

	private static VendingMachineController createVendingMachineController() {
		vendingMachineRepository = createVendingMachineRepository(generateCoins(), createItemRepository(), inputMoney());
		VendingMachineController controller = new VendingMachineController(itemRepository, vendingMachineRepository);
		return controller;
	}

	private static Coins generateCoins() {
		Coins coins = new CoinsGenerator().generate(ExchangeAmountReader.recursiveReader().read());
		System.out.println("자판기가 보유한 동전");
		coins.stream().forEach(coin -> System.out.println(coin.getAmount() + "원 - " + coins.getCount(coin) + "개"));
		return coins;
	}

	private static ItemRepository createItemRepository() {
		itemRepository = new ItemRepository();
		itemRepository.saveAll(ItemListReader.recursiveReader().read());
		return itemRepository;
	}

	private static int inputMoney() {
		int inputMoney = InputMoneyReader.recursiveReader().read();
		return inputMoney;
	}

	private static VendingMachineRepository createVendingMachineRepository(Coins coins, ItemRepository itemRepository, int inputMoney) {
		vendingMachineRepository = new VendingMachineRepository();
		vendingMachineRepository.save(new VendingMachine(coins, itemRepository, inputMoney));
		return vendingMachineRepository;
	}
}
