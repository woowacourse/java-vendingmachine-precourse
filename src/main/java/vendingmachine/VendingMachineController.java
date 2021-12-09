package vendingmachine;

import java.util.List;
import vendingmachine.model.coin.Coins;
import vendingmachine.model.coin.CoinsGenerator;
import vendingmachine.model.item.Item;
import vendingmachine.model.item.ItemRepository;
import vendingmachine.model.machine.VendingMachine;
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
		Coins coins = generateCoins();
		saveItemsToRepository();
		int inputMoney = inputMoney();
		vendingMachine = new VendingMachine(coins, itemRepository, inputMoney);
	}

	private Coins generateCoins() {
		int exchangeAmount = exchangeAmountReader.read();
		Coins coins = new CoinsGenerator().generate(exchangeAmount);
		printExchangeCoins(coins);
		return coins;
	}

	private void printExchangeCoins(Coins coins) {
		System.out.println("자판기가 보유한 동전");
		coins.stream().forEach(coin -> System.out.println(coin.getAmount() + "원 - " + coins.getCount(coin) + "개"));
	}

	private void saveItemsToRepository() {
		itemRepository.saveAll(itemListReader.read());
	}

	private int inputMoney() {
		int inputMoney = inputMoneyReader.read();
		System.out.println("투입 금액: " + inputMoney);
		return inputMoney;
	}

	private void service() {
		while(true) {
			String name = purchaseItemNameReader.read();
			Item item = itemRepository.findByName(name);
			vendingMachine.sell(item);
			System.out.println("투입 금액: " + vendingMachine.getInputMoney());
		}
	}
}
