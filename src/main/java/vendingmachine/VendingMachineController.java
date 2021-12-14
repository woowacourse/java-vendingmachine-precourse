package vendingmachine;

import static vendingmachine.constants.Message.*;
import static vendingmachine.utils.View.showCoins;
import static vendingmachine.utils.View.showMoney;

import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Items;
import vendingmachine.service.ChangeService;
import vendingmachine.service.OrderService;
import vendingmachine.service.UserService;

public class VendingMachineController {
	private final Coins coins = new Coins();
	private final UserService userService = new UserService();
	private final OrderService orderService = new OrderService();
	private final ChangeService changeService = new ChangeService();

	public void run() {
		Map<Coin, Integer> vendingMachineCoins = getVendingMachineCoins();
		showCoins(vendingMachineCoins, ANSWER_POSSESSION_COIN);

		Items forSaleItems = userService.registerItems();
		int remainedMoney = getUserMoneyAndOrderItems(forSaleItems);

		returnChangeToUser(vendingMachineCoins, remainedMoney);
	}

	private void returnChangeToUser(Map<Coin, Integer> vendingMachineCoins, int remainedUserMoney) {
		Map<Coin, Integer> returnChange = changeService.returnChange(vendingMachineCoins, remainedUserMoney);

		showCoins(returnChange, ANSWER_CHANGE_COIN);
	}

	private int getUserMoneyAndOrderItems(Items forSaleItems) {
		int userMoney = userService.getUserMoney();
		int remainedMoney = orderProcess(forSaleItems, userMoney);
		showMoney(remainedMoney);

		return remainedMoney;
	}

	private Map<Coin, Integer> getVendingMachineCoins() {
		int vendingMachinePossession = userService.getVendingMachinePossession();
		return coins.createCoins(vendingMachinePossession);
	}

	private int orderProcess(Items forSaleItems, int currentUserMoney) {
		while (orderService.canPurchaseAnyItems(currentUserMoney, forSaleItems)) {
			currentUserMoney = orderService.orderItem(forSaleItems, currentUserMoney);
		}

		return currentUserMoney;
	}
}
