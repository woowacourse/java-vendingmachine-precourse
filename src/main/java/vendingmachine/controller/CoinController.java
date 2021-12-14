package vendingmachine.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class CoinController {
	private static final int ZERO = 0;
	private static final String ERROR = "[ERROR] ";
	private static final String ERROR_COIN_MINIMUM_AMOUNT_MISMATCH = ERROR
		+ "최소 동전의 단위에 맞게 자판기 보유 금액을 입력해야 합니다.";

	private final InputView inputView;
	private final OutputView outputView;
	private Coins coins;

	public CoinController(final InputView inputView, final OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void setupHoldingCoins() {
		this.coins = initializeCoins();
		outputView.printHoldingCoins(coins.findAll());
	}

	public Coins initializeCoins() {
		try {
			outputView.printHoldingAmountRequest();
			int amount = inputView.scanAmount();
			return new Coins(makeCoins(amount));
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return initializeCoins();
		}
	}

	private Map<Coin, Integer> makeCoins(int holdingAmount) {
		Map<Coin, Integer> coinAmount = new LinkedHashMap<>();
		for (Coin coin : Coin.values()) {
			int amount = coin.getAmount();
			coinAmount.put(coin, holdingAmount / amount);
			holdingAmount %= amount;
		}
		if (ZERO < holdingAmount) {
			throw new IllegalArgumentException(ERROR_COIN_MINIMUM_AMOUNT_MISMATCH);
		}
		return coinAmount;
	}

	public Map<Coin, Integer> getRestCoins() {
		return coins.findRestCoins();
	}

	public int getAvailableChangeNumber(final int coin, final int number, final int money) {
		if (coin * number > money) { // 동전 총액 > 투입 금액인 경우 (example: 100원 * 3 (300원) > 투입금액 200원)
			return money / coin;
		}
		return number;
	}

	public void reduceCoins(final Map<Coin, Integer> reducedCoins) {
		coins.reduce(reducedCoins);
	}
}
