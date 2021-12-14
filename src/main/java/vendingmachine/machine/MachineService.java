package vendingmachine.machine;

import static vendingmachine.constant.Constant.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.coin.Coin;
import vendingmachine.coin.CoinService;
import vendingmachine.product.Product;
import vendingmachine.product.ProductService;

public class MachineService {

	private final CoinService coinService = new CoinService();
	private final ProductService productService = new ProductService();

	public void makeCoins(Machine machine, int money) {
		Map<Coin, Integer> coins = machine.getCoins();
		while (money > 0) {
			Coin coin = coinService.findCoinByPrice(money);
			coins.put(coin, coins.get(coin) + 1); //선택된 코인 1개 증가
			money -= coin.getAmount();
		}
	}

	public void makeProductList(Machine machine, String infoList) {
		List<Product> productList = machine.getProductList();

		Arrays.stream(infoList.split(PRODUCT_SPLITTER))
			.forEach(info -> {
				productList.add(productService.makeProduct(info));
			});
	}

	public void insertMoney(Machine machine, int money) {
		machine.insertMoney(money);
	}

	public void buyProduct(Machine machine, String productName) {
		Product product = productService.buyProduct(machine, productName);
		machine.buyProduct(product);
	}

	public Map<Integer, Integer> returnChanges(Machine machine) {
		Map<Integer, Integer> changes = new HashMap<>();
		machine.getCoins().entrySet().stream()
			.filter(entry -> entry.getValue() > 0)
			.sorted(Comparator.comparingInt(entry -> -entry.getKey().getAmount()))
			.forEach(entry -> {
				int changesNum = machine.giveChanges(entry.getKey(), entry.getValue());
				if (changesNum > 0) {
					changes.put(entry.getKey().getAmount(), changesNum);
				}
			});
		return changes;
	}
}
