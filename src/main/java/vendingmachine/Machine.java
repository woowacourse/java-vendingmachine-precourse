package vendingmachine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Machine {

	private static final String REQUEST_MSG_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	private int money;
	private HashMap<Coin, Integer> wallet;

	public void run() {
		inputMachineMoney();
		setMachineCoin(this.money);
	}

	public void inputMachineMoney() {
		System.out.println(REQUEST_MSG_MACHINE_MONEY);
		String userInput = Console.readLine();
		try {
			Validator.isNumeric(userInput);
			Validator.minimumCheck(userInput);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			inputMachineMoney();
		}
		this.money = Integer.parseInt(userInput);
	}

	public void setWallet() {
		this.wallet = new HashMap<>();
		for (Coin coin : Arrays.stream(Coin.values()).collect(Collectors.toList())) {
			this.wallet.put(coin, 0);
		}
	}

	public void setMachineCoin(int money) {
		setWallet();
		int target = money;
		while (target > 0) {
			Coin coin = Coin.pickRandomCoin();
			if (Coin.hasEnoughMoney(target,coin)) {
				target -= coin.getAmount();
				wallet.put(coin, wallet.get(coin) + 1);
			}
		}
	}

}
