package vendingmachine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class MachineView {
	private static final String REQUEST_MSG_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String INFORMATION_MSG_MACHINE_CHANGE = "자판기가 보유한 동전";
	private static final String REQUEST_MSG_MACHINE_PRODUCT = "상품명과 가격, 수량을 입력해주세요.";
	private static final String INFORMATION_MSG_CHANGE = "잔돈";
	private static final String REQUEST_MSG_INPUT_PRODUCT_NAME = "구입할 상품명을 입력해 주세요.";

	public static void requestMoney() {
		System.out.println(REQUEST_MSG_MACHINE_MONEY);
	}

	public static void openWallet(Machine machine) {
		System.out.println(INFORMATION_MSG_MACHINE_CHANGE);
		for (Coin coin : Arrays.stream(Coin.values()).collect(Collectors.toList())) {
			System.out.println(coin.getAmount() + "원 - " + machine.findCoinInWallet(coin) + "개");
		}
	}

	public static void requestProductList() {
		System.out.println(REQUEST_MSG_MACHINE_PRODUCT);
	}

	public static void giveTheChange(Customer customer, Machine machine) {
		System.out.println(INFORMATION_MSG_CHANGE);
		int target = customer.getMoney();
		for (Coin coin : Arrays.stream(Coin.values()).collect(Collectors.toList())) {
			if (coin.hasBiggerAmount(target)) {
				continue;
			}
			if (!machine.hasCoin(coin)) {
				continue;
			}
			int coinCount = Math.min(target / coin.getAmount(), machine.findCoinInWallet(coin));
			target -= coinCount * coin.getAmount();
			System.out.println(coin.getAmount() + "원 - " + coinCount + "개");
		}
	}

	public static void requestProduct() {
		System.out.println(REQUEST_MSG_INPUT_PRODUCT_NAME);
	}


}
