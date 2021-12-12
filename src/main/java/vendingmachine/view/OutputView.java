package vendingmachine.view;

import java.util.List;

import vendingmachine.domain.Coin;
import vendingmachine.view.messages.Message;

public class OutputView {

	public void printInputSavedMoney() {
		System.out.println(Message.INPUT_SAVED_MONEY);
	}

	public void printMachineSavedCoin(List<Coin> coins) {
		System.out.println(Message.MACHINE_SAVED_COIN);
		coins.stream()
			.forEach(coin -> System.out.println(coin.toString()));
	}

	public void printInputSavedItems() {
		System.out.println(Message.INPUT_SAVED_ITEMS);
	}

	public void printInputCustomerMoney() {
		System.out.println(Message.INPUT_CUSTOMER_MONEY);
	}

	public void printCustomerMoney(int customerMoney) {
		System.out.println(Message.INPUT_MONEY + customerMoney + Message.MONEY_UNIT);
	}

	public void printInputPurchaseItem() {
		System.out.println(Message.INPUT_PURCHASE_ITEM);
	}

	public void printRemainingMessage() {
		System.out.println(Message.REMAINING);
	}

	public void printRemainingCoin(Coin coin) {
		System.out.println(coin.toStringRemainingNumber());
	}
}
