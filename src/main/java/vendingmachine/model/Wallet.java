package vendingmachine.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.validation.WalletValidation;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;

public class Wallet {

	private final Map<Coin, Integer> wallet = new LinkedHashMap<>();

	public Wallet() {
		setDefaultWallet();
		setWallet();

		wallet.forEach((coin, integer) -> System.out.println("coin = " + coin +" : "+ integer));
	}

	private void setDefaultWallet() {
		Coin[] coins = Coin.values();
		Arrays.stream(coins).forEach(coin -> wallet.put(coin, 0));
	}

	private void setWallet() {
		try {
			String input = InputView.setVendingMachineWallet();
			WalletValidation.setWalletValidation(input);
			makeRandomCoin(Integer.parseInt(input));
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.illegalArgumentException(illegalArgumentException.getMessage());
			setWallet();
		}
	}

	private void makeRandomCoin(int money) {
		Coin[] coins = Coin.values();
		while (money != 0) {
			int idx = Randoms.pickNumberInRange(0, coins.length-1);
			if (coins[idx].getAmount() <= money) {
				money = reduceMoney(money, coins[idx]);
				addCoin(coins[idx]);
			}
		}
	}

	private void addCoin(Coin coin) {
		wallet.put(coin, wallet.get(coin) + 1);
	}

	private int reduceMoney(int money ,Coin coin) {
		return money - coin.getAmount();
	}
}
