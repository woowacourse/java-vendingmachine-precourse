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
import vendingmachine.reader.Reader;

public class VendingMachineController {
	private final ItemRepository itemRepository = new ItemRepository();
	private final Reader<Integer> exchangeAmountReader = ExchangeAmountReader.create();
	private final Reader<List<Item>> itemListReader = ItemListReader.create();
	private final Reader<Integer> inputMoneyReader = InputMoneyReader.create();
	private final Reader<String> purchaseItemNameReader = PurchaseItemNameReader.create(itemRepository);
	private VendingMachine vendingMachine;

	public void run() {
		init();
		service();
	}

	private void init() {
		int exchangeAmount = inputExchangeAmount();
		Coins coins = generateCoins(exchangeAmount);
		saveItems();

		int inputMoney = inputMoney();
		printInputMoney(inputMoney);

		vendingMachine = new VendingMachine(coins, itemRepository, inputMoney);
	}

	private int inputExchangeAmount() {
		try {
			return exchangeAmountReader.read();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputExchangeAmount();
		}
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
		itemRepository.saveAll(inputItems());
	}

	private List<Item> inputItems() {
		try {
			return itemListReader.read();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return inputItems();
		}
	}

	private int inputMoney() {
		try {
			return inputMoneyReader.read();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputMoney();
		}
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
