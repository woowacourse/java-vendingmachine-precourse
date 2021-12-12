package vendingmachine.model;

import vendingmachine.controller.ConsumerController;
import vendingmachine.domain.Consumer;
import vendingmachine.domain.Item;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.ConsumerMessage;
import vendingmachine.view.ErrorMessage;
import vendingmachine.view.ItemMessage;

public class PurchaseService {
	public static Consumer serveCustomer(VendingMachine vendingMachine) {
		ConsumerMessage.printInputMoneyMessage();
		Consumer consumer = Consumer.create(ConsumerController.getInputMoney());

		while (canBuyMore(vendingMachine, consumer)) {
			try {
				buy(vendingMachine, consumer);
			} catch (IllegalArgumentException illegalArgumentException) {
				System.out.println(illegalArgumentException.getMessage());
				buy(vendingMachine, consumer);
			}
		}
		return consumer;
	}

	private static boolean canBuyMore(VendingMachine vendingMachine, Consumer consumer) {
		return consumer.getMoney() >= vendingMachine.getMinPrice();
	}

	public static void buy(VendingMachine vendingMachine, Consumer consumer) {
		ConsumerMessage.printCurrentStatusMessage(consumer);
		ItemMessage.printWhatToBuyMessage();
		Item item = ConsumerController.getPurchaseItemName(vendingMachine.getItemList());

		if (consumer.cannotAfford(item)) {
			throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_MONEY);
		}

		consumer.buy(item);
		item.sold();
	}
}
