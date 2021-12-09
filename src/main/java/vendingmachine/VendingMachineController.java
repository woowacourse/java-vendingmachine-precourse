package vendingmachine;

import java.util.List;
import vendingmachine.model.Coins;
import vendingmachine.model.CoinsGenerator;
import vendingmachine.model.Item;
import vendingmachine.model.ItemRepository;
import vendingmachine.model.VendingMachine;
import vendingmachine.reader.ExchangeAmountReader;
import vendingmachine.reader.InputMoneyReader;
import vendingmachine.reader.ItemListReader;
import vendingmachine.reader.PurchaseItemNameReader;
import vendingmachine.reader.RecursiveReader;

public class VendingMachineController {
	private final ItemRepository itemRepository = new ItemRepository();
	private final RecursiveReader<Integer> exchangeAmountReader = ExchangeAmountReader.recursiveReader();
	private final RecursiveReader<List<Item>> itemListReader = ItemListReader.recursiveReader();
	private final RecursiveReader<Integer> inputMoneyReader = InputMoneyReader.recursiveReader();
	private final RecursiveReader<String> purchaseItemNameReader = PurchaseItemNameReader.recursiveReader(itemRepository);
	private VendingMachine vendingMachine;

	public void run() {
		init();
		service();
	}

	private void init() {
		int exchangeAmount = exchangeAmountReader.read();
		Coins coins = generateCoins(exchangeAmount);
		saveItems();

		int inputMoney = inputMoneyReader.read();
		printInputMoney(inputMoney);

		vendingMachine = new VendingMachine(coins, itemRepository, inputMoney);
	}

	private Coins generateCoins(int amount) {
		Coins coins = new CoinsGenerator().generate(amount);
		printExchangeCoins(coins);
		return coins;
	}

	private void printExchangeCoins(Coins coins) {
		System.out.println("자판기가 보유한 동전");
		coins.stream().forEach(coin -> System.out.println(coin.getAmount() + "원 - " + coins.getCount(coin) + "개"));
	}

	private void saveItems() {
		itemRepository.saveAll(itemListReader.read());
	}

	private void printInputMoney(int inputMoney) {
		System.out.println("투입 금액: " + inputMoney);
	}

	private void service() {
		while(true) {
			String name = purchaseItemNameReader.read();
			System.out.println(name);
		}
	}
}
