package vendingmachine;

import java.util.List;
import vendingmachine.model.Coins;
import vendingmachine.model.CoinsGenerator;
import vendingmachine.model.Item;
import vendingmachine.model.ItemRepository;
import vendingmachine.reader.ExchangeAmountReader;
import vendingmachine.reader.InputMoneyReader;
import vendingmachine.reader.ItemListReader;
import vendingmachine.reader.PurchaseItemNameReader;
import vendingmachine.reader.validator.NoopValidator;

public class Application {
	public static void main(String[] args) {
		ItemRepository itemRepository = new ItemRepository();

		int amount = ExchangeAmountReader.create().read();
		Coins coins = generateCoins(amount);

		List<Item> items = ItemListReader.create().read();
		itemRepository.saveAll(items);

		int inputMoney = InputMoneyReader.create().read();
		printInputMoney(inputMoney);

		String name = PurchaseItemNameReader.create(itemRepository).read();
		System.out.println(name);
	}

	private static Coins generateCoins(int amount) {
		Coins coins = new CoinsGenerator().generate(amount);
		printExchangeCoins(coins);
		return coins;
	}

	private static void printExchangeCoins(Coins coins) {
		System.out.println("자판기가 보유한 동전");
		coins.stream().forEach(coin -> System.out.println(coin.getAmount() + "원 - " + coins.getCount(coin) + "개"));
	}

	private static void printInputMoney(int inputMoney) {
		System.out.println("투입 금액: " + inputMoney);
	}
}
