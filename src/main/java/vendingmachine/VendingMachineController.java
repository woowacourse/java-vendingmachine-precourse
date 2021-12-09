package vendingmachine;

import vendingmachine.model.coin.Coins;
import vendingmachine.model.item.Item;
import vendingmachine.model.item.ItemRepository;
import vendingmachine.model.machine.VendingMachine;
import vendingmachine.model.machine.VendingMachineRepository;
import vendingmachine.reader.PurchaseItemNameReader;
import vendingmachine.reader.RecursiveReader;

public class VendingMachineController {
	private final ItemRepository itemRepository;
	private final VendingMachineRepository vendingMachineRepository;
	private final RecursiveReader<String> purchaseItemNameReader;;

	public VendingMachineController(ItemRepository itemRepository,
	                                VendingMachineRepository vendingMachineRepository) {
		this.itemRepository = itemRepository;
		this.vendingMachineRepository = vendingMachineRepository;
		purchaseItemNameReader = PurchaseItemNameReader.recursiveReader(itemRepository, vendingMachineRepository);
	}

	public void run() {
		VendingMachine vendingMachine = vendingMachineRepository.find();

		while(isSalable(vendingMachine)) {
			printRemainInputMoney(vendingMachine);
			vendingMachine.sell(purchaseItem());
		}

		printRemainInputMoney(vendingMachine);
		printExchangeByCoin(vendingMachine.getRemainInputMoney());
	}

	private boolean isSalable(VendingMachine vendingMachine) {
		return !isAllSoldOut() && isOverAndEqualMoney(vendingMachine);
	}

	private boolean isOverAndEqualMoney(VendingMachine vendingMachine) {
		Item lowestPriceItem = itemRepository.findLowestPriceItem();
		return vendingMachine.isOverAndEqualMoney(lowestPriceItem);
	}

	private boolean isAllSoldOut() {
		return itemRepository.isAllSoldOut();
	}

	private void printRemainInputMoney(VendingMachine vendingMachine) {
		System.out.println("투입 금액: " + vendingMachine.getInputMoney());
	}

	private Item purchaseItem() {
		String name = purchaseItemNameReader.read();
		return itemRepository.findByName(name);
	}

	private void printExchangeByCoin(Coins coins) {
		System.out.println("잔돈");
		coins.stream().forEach(coin -> System.out.println(coin.getAmount() + "원 - " + coins.getCount(coin) + "개"));
	}
}
