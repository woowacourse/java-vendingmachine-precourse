package vendingmachine;

import vendingmachine.model.coin.Coins;
import vendingmachine.model.item.Item;
import vendingmachine.model.item.ItemRepository;
import vendingmachine.model.machine.VendingMachine;
import vendingmachine.model.machine.VendingMachineRepository;
import vendingmachine.reader.PurchaseItemNameReader;
import vendingmachine.reader.RecursiveReader;

public class VendingMachineController {
	private final RecursiveReader<String> purchaseItemNameReader;;

	public VendingMachineController() {
		purchaseItemNameReader = PurchaseItemNameReader.recursiveReader();
	}

	public void run() {
		VendingMachine vendingMachine = VendingMachineRepository.find();

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
		Item lowestPriceItem = ItemRepository.findLowestPriceItem();
		return vendingMachine.isOverAndEqualMoney(lowestPriceItem);
	}

	private boolean isAllSoldOut() {
		return ItemRepository.isAllSoldOut();
	}

	private void printRemainInputMoney(VendingMachine vendingMachine) {
		System.out.println("투입 금액: " + vendingMachine.getInputMoney() + "원");
	}

	private Item purchaseItem() {
		String name = purchaseItemNameReader.read();
		return ItemRepository.findByName(name);
	}

	private void printExchangeByCoin(Coins coins) {
		System.out.println("잔돈");
		coins.stream().forEach(coin -> System.out.println(coin.getAmount() + "원 - " + coins.getCount(coin) + "개"));
	}
}
