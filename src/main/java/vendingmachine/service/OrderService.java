package vendingmachine.service;

import java.util.HashMap;

import vendingmachine.constants.OrderConstant;
import vendingmachine.repository.Coin;
import vendingmachine.repository.Money;
import vendingmachine.repository.Product;
import vendingmachine.repository.Products;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class OrderService {
	OrderValidator orderValidator = new OrderValidator();
	Products products;
	Money money;
	HashMap<Coin, Integer> map = new HashMap<>();

	public void get(Products products) {
		this.products = products;
		OutputView.printOrderMoney();
		getUserMoney();
		getProduct();
		returnCoin();
	}

	public void returnCoin() {
		OutputView.printReturnCoin();
		giveMinimumCoin(money.getRemainder());
		OutputView.printCoinResult(map);
	}

	public void giveMinimumCoin(int remainder) {
		for (Coin coin : Coin.values()) {
			remainder = getMinimumCoin(coin, remainder);
		}

	}

	public int getMinimumCoin(Coin coin, int remainder) {
		map.put(coin, OrderConstant.COIN_STCOK_INIT_VAL);
		if (coin.getAmount() > remainder) {
			return remainder;
		}
		if (coin.getStock() == 0) {
			return remainder;
		}
		return subtractRemainder(coin, remainder);
	}

	public int subtractRemainder(Coin coin, int remainder) {
		int possibleNumber = remainder / coin.getAmount();
		if (coin.getStock() >= possibleNumber) {
			coin.subtractStock(possibleNumber);
			map.put(coin, possibleNumber);
			return remainder % coin.getAmount();
		}
		remainder -= coin.getAmount() * coin.getStock();
		map.put(coin, coin.getStock());
		coin.setStock(OrderConstant.COIN_STCOK_INIT_VAL);
		return remainder;
	}

	public void getUserMoney() {
		while (true) {
			try {
				String tempMoney = InputView.getMoney();
				orderValidator.isValidMoney(tempMoney);
				money = new Money(Integer.parseInt(tempMoney));
				return;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void getProduct() {
		while (true) {
			OutputView.printInputMoney(money.getRemainder());
			if (isEnd()) {
				return;
			}
			Product userProduct = getOrderFromUser();
			subtract(userProduct, money);
		}
	}

	public boolean isEnd() {
		if (compareLowestAndRemainder()) {
			return true;
		}
		return products.isOutOfStock(money.getRemainder());
	}

	public boolean compareLowestAndRemainder() {
		return products.getLowestPrice() > money.getRemainder();
	}

	public void subtract(Product userProduct, Money money) {
		userProduct.subtractStock();
		money.subtract(userProduct.getPrice());
	}

	public Product getOrderFromUser() {
		while (true) {
			OutputView.printProduct();
			try {
				String userOrder = InputView.getOrder();
				isValidOrder(userOrder);
				return products.getProduct(userOrder);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public boolean isValidOrder(String userOrder) {
		orderValidator.isExistProduct(userOrder, products);
		isPossiblePrice(userOrder);
		orderValidator.hasStock(userOrder, products);
		return true;
	}

	public boolean isPossiblePrice(String userOrder) {
		for (Product product : products.getProducts()) {
			if (product.isSameName(userOrder)) {
				orderValidator.isPossiblePrice(product, money);
			}
		}
		return true;
	}
}