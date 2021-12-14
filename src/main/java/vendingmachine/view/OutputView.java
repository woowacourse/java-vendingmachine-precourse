package vendingmachine.view;

import static java.lang.System.*;
import static vendingmachine.constant.SystemMessage.*;

import java.util.List;
import java.util.Map;

import vendingmachine.constant.SystemMessage;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.repository.ItemRepository;

public class OutputView {

	public static void printMachineCoins() {
		List<Coin> coins = Coin.get();
		out.println(OUTPUT_MACHINE_MONEY);
		coins.forEach(Coin::selfDescription);
		SystemMessage.printEmptyLine();
	}

	public static void printChanges(Map<Integer, Integer> changes, int remainingMoney) {
		out.println(OUTPUT_CHANGES);
		for (Map.Entry<Integer, Integer> entry : changes.entrySet()) {
			Integer coinAmount = entry.getKey();
			Integer coinCount = entry.getValue();
			out.printf(SELF_DESCRIPTION_FORMAT, coinAmount, coinCount);
		}
	}

	/**
	 * 요구사항에 없는 출력입니다 !
	 */
	public static void printItemAfterBuying() {
		out.println("=== 자판기 재고 ===");
		List<Item> items = ItemRepository.get();
		for (Item item : items) {
			out.println("item = " + item);
		}
		SystemMessage.printEmptyLine();
	}

	/**
	 * 요구사항에 없는 출력입니다 !
	 */
	public static void printMachineChangesAfterBuying() {
		out.println("=== 자판기 잔돈 ===");
		for (Coin coin : Coin.values()) {
			out.println("coin = " + coin);
		}
		SystemMessage.printEmptyLine();
	}
}
