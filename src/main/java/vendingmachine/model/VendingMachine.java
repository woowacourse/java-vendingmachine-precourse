package vendingmachine.model;

import java.util.Map;

import vendingmachine.repository.CoinRepository;
import vendingmachine.repository.ProductRepository;

public class VendingMachine {

	private int deposit;
	private ProductRepository productRepository;
	private CoinRepository coinRepository;
	private Changes changes = new Changes();

	public VendingMachine(int deposit, ProductRepository productRepository, CoinRepository coinRepository) {
		this.deposit = deposit;
		this.productRepository = productRepository;
		this.coinRepository = coinRepository;
	}

	public ProductRepository getProductList() {
		return productRepository;
	}

	public int getDeposit() {
		return deposit;
	}

	public void subtractDeposit(int price) {
		this.deposit -= price;
	}

	public boolean isContinueToSell() {
		int minimumPrice = productRepository.getMinimumPrice();
		if (minimumPrice > deposit) {
			return false;
		}

		if (productRepository.isOutOfStock()) {
			return false;
		}

		return true;
	}

	public Changes createChanges() {
		for (Map.Entry<Coin, Integer> entry : coinRepository.getCoins()) {
			if (deposit == 0) {
				break;
			}

			if (entry.getValue() == 0) {
				continue;
			}

			subtractFromCoinListAndAddChange(entry.getKey(), entry.getValue());
		}

		return changes;
	}

	private void subtractFromCoinListAndAddChange(Coin coin, int availableNumberOfCoins) {
		int numberOfChange = getNumberOfChange(coin, availableNumberOfCoins);
		if (numberOfChange == 0) {
			return;
		}

		coinRepository.subtractCoin(coin, availableNumberOfCoins - numberOfChange);
		changes.addCoin(coin, numberOfChange);
	}

	private int getNumberOfChange(Coin coin, int maxNumberOfCoins) {
		for (int i = maxNumberOfCoins; i >= 0; i--) {
			if (deposit >= (i * coin.getAmount())) {
				deposit -= (i * coin.getAmount());
				return i;
			}
		}

		return 0;
	}

}
