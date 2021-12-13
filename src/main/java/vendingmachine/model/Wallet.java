package vendingmachine.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.validation.WalletValidation;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Wallet {

	private final Map<Coin, Integer> wallet = new LinkedHashMap<>();

	public Wallet() {
		setDefaultWallet();
		setWallet();
		OutputView.containCoins(this);
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
		while (money != 0) {
			int value = Randoms.pickNumberInList(Coin.getCoinValues());
			if (value <= money) {
				money -= value;
				addCoin(Coin.getCoinByValue(value));
			}
		}
	}

	private void addCoin(Coin coin) {
		wallet.put(coin, wallet.get(coin) + 1);
	}

	public Map<Coin, Integer> getWallet() {
		return wallet;
	}

	public Coin canReturn(int remain) {
		for (Map.Entry<Coin, Integer> entry : wallet.entrySet()) {
			if (entry.getKey().getAmount() <= remain && entry.getValue() > 0) {
				return entry.getKey();
			}
		}
		return null;
	}

	public void reduceCoin(Coin coin) {
		wallet.put(coin, wallet.get(coin) - 1);
	}
}
