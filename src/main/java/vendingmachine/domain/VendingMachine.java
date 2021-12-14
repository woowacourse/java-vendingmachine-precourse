package vendingmachine.domain;

import static vendingmachine.utils.Constant.ZERO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.view.OutputView;

public class VendingMachine {
	private static final HashMap<Integer, Integer> coins = new HashMap<>();
	private static final List<Product> products = new ArrayList<>();
	private final int changeAmount;

	public VendingMachine(int amount) {
		changeAmount = amount;
		makeCoins();
	}
	
	public void initProducts() {
		products.clear();
	}
	
	public int getChange() {
		return changeAmount;
	}
	
	public HashMap<Integer, Integer> getCoins(){
		return coins;
	}
	
	public List<Product> getProducts(){
		return products;
	}

	/**** action ****/
	public void addProduct(Product item) {
		products.add(item);
	}

	public void makeCoins() {
		int sumAmount = 0;
		while (sumAmount < changeAmount) {
			int coin = Randoms.pickNumberInList(coinFilter(sumAmount));
			sumAmount += coin;
			coins.put(coin, coins.getOrDefault(coin, ZERO) + 1);
		}
	}
	
	public List<Integer> coinFilter(int sumAmount) {
		return Coin.getAmountList()
				.stream()
				.filter(amount -> amount <= (changeAmount-sumAmount))
				.collect(Collectors.toList());
	}
	
	public Optional<Product> findProduct(String name) {
		Optional<Product> product = products.stream().filter(p -> p.getName().equals(name)).findFirst();
		return product;
	}
	
	public int getMinimumPrice() {
		return products.stream()
				.map(Product::getPrice)
				.sorted()
				.collect(Collectors.toList()).get(ZERO);
	}

	public void print_coins() {
		OutputView.print_line();
		
		List<Integer> list= Coin.getAmountList();
		for (int i = 0; i < list.size(); i++) {
			int coin = list.get(i);
			int count = coins.getOrDefault(coin, ZERO);
			OutputView.print_coins(coin, count);
		}
		OutputView.print_line();
	}

}
