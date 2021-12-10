package vendingmachine;

import vendingmachine.model.item.Item;
import vendingmachine.model.item.ItemRepository;
import vendingmachine.model.machine.VendingMachine;
import vendingmachine.model.machine.VendingMachineRepository;
import vendingmachine.reader.PurchaseItemNameReader;
import vendingmachine.reader.RecursiveReader;

public class VendingMachineController {
	private final RecursiveReader<String> purchaseItemNameReader;

	public VendingMachineController() {
		purchaseItemNameReader = PurchaseItemNameReader.recursiveReader();
	}

	public void run() {
		VendingMachine vendingMachine = VendingMachineRepository.find();

		while (isSalable(vendingMachine)) {
			Item purchaseItem = getPurchaseItem();
			purchaseItem.sell();
			vendingMachine.pay(purchaseItem.getPrice());
		}

		vendingMachine.close();
	}

	private Item getPurchaseItem() {
		String name = purchaseItemNameReader.read();
		return ItemRepository.findByName(name);
	}

	private boolean isSalable(VendingMachine vendingMachine) {
		return !isAllSoldOut() && hasEnoughMoney(vendingMachine);
	}

	private boolean isAllSoldOut() {
		return ItemRepository.isAllSoldOut();
	}

	private boolean hasEnoughMoney(VendingMachine vendingMachine) {
		Item lowestPriceItem = ItemRepository.findLowestPriceItem();
		return vendingMachine.hasEnoughMoney(lowestPriceItem.getPrice());
	}
}
