package vendingmachine.service;

import static vendingmachine.utils.Constant.ZERO;

import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.OutputView;

public class VendingService {
	private VendingMachine machine;

	public void makeVendingMachine(int amount) {
		machine = new VendingMachine(amount);
	}
	
	public VendingMachine getMachine() {
		return machine;
	}

	public void printCoins() {
		OutputView.print_line();

		List<Integer> list = Coin.getAmountList();
		for (int i = 0; i < list.size(); i++) {
			int coin = list.get(i);
			int count = machine.getCoins().getOrDefault(coin, ZERO);
			OutputView.print_coins(coin, count);
		}
		OutputView.print_line();
	}

	public void addProduct(List<Product> input) {
		for (int i = 0; i < input.size(); i++) {
			machine.addProduct(input.get(i));
		}
	}

	public int buyProduct(int money, String name) {
		Product product = machine.getProducts().stream()
				.filter(p-> p.getName().equals(name))
				.collect(Collectors.toList())
				.get(ZERO);
		product.sellProduct();
		return money-product.getPrice();
	}
	
	public void getChange(int money) {
		List<Integer> coinList= Coin.getAmountList();
		int changeAmount= machine.getChange();
		
		for(int i=0; i<coinList.size(); i++) {
			int coin = coinList.get(i);
			int count = machine.getCoins().getOrDefault(coin, ZERO);
			
			if(count==0||money<coin||changeAmount<coin) continue;
			int sum= calculator(money, changeAmount, coin, count);
			changeAmount -= sum;
			money -= sum;
		}
	}
	
	public int calculator(int money, int change, int coin, int count) {
		while(change<coin*count||money<coin*count) {
			count--;
		}
		OutputView.print_coins(coin, count);
		return coin*count;
	}

}
