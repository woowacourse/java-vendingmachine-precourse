package vendingmachine.firstclass;

import vendingmachine.model.CoinStock;
import vendingmachine.util.CoinCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CoinStocks {

	private List<CoinStock> coinStocks = new ArrayList<>();

	public CoinStocks(List<CoinStock> coinStocks) {
		this.coinStocks = coinStocks;
	}

	public CoinStocks getReturnCoins(int money) {
		CoinCalculator coinCalculator = new CoinCalculator();
		return new CoinStocks(coinCalculator.combineCoinsByGreedy(this.coinStocks, money));
	}

	@Override
	public String toString() {
		return coinStocks.stream()
				.map(CoinStock::toString).collect(Collectors.joining("\n"));
	}
}
