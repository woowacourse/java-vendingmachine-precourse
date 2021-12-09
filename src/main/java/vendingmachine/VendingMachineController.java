package vendingmachine;

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

		while(true) {
			System.out.println("투입 금액: " + vendingMachine.getInputMoney());
			String name = purchaseItemNameReader.read();
			Item item = itemRepository.findByName(name);
			vendingMachine.sell(item);
		}
	}
}
