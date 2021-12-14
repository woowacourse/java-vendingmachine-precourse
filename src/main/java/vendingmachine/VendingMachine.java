package vendingmachine;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
	private ArrayList<Product> products = null;

	public VendingMachine(int amount) {
		List<Integer> li = new ArrayList<>();
		li.add(500);
		li.add(100);
		li.add(50);
		li.add(10);

		while (amount > 0) {
			int selected = Randoms.pickNumberInList(li);
			if (amount - selected >= 0) {
				amount -= selected;
				Coin.getEnumCoin(selected).increaseCount(1);
			}
		}
	}

	public void setInitProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public void buyProducts(int coin) {
		int inputCoin = coin;
		while (!isFinished(inputCoin)) {
			System.out.println("\n투입 금액: " + inputCoin + "원");
			System.out.println(Constants.productNameMsg);
			Product buy = getProduct();
			inputCoin -= buy.getPrice();
			decreaseProduct(buy);
		}
		System.out.println("\n투입 금액: " + inputCoin + "원");
		ArrayList<Integer> returnCoin = calculateReturnCoin(inputCoin);
		printReturnCoin(returnCoin);
	}

	public ArrayList<Integer> calculateReturnCoin(int inputCoin) {
		ArrayList<Integer> coins = new ArrayList<>();
		for (Coin c: Coin.values()) {
			int quotient = inputCoin / c.getAmount();
			if (quotient > c.getCount()) {
				inputCoin -= c.getAmount() * c.getCount();
				coins.add(c.getCount());
				continue;
			}
			inputCoin -= c.getAmount() * quotient;
			coins.add(quotient);
			continue;
		}
		return coins;
	}

	public void printReturnCoin(ArrayList<Integer> returnCoin) {
		System.out.println("잔돈");
		String[] amounts = {"500", "100", "50", "10"};
		for (int i = 0; i < 4; i++) {
			if (returnCoin.get(i) == 0) {
				continue;
			}
			System.out.println(amounts[i] + "원" + " - " + returnCoin.get(i) + "개");
		}
	}

	public void decreaseProduct(Product buy) {
		for (Product p: this.products) {
			if (p.getName().equals(buy.getName())) {
				p.decreaseCount();
				return;
			}
		}
	}

	public Product getProduct() {
		while (true) {
			try {
				String input = camp.nextstep.edu.missionutils.Console.readLine();
				return checkProductExist(input);
			} catch (IllegalArgumentException exception) {
				System.out.println(exception.getMessage());
				continue;
			}
		}
	}

	public Product checkProductExist(String input) {
		for (Product p: this.products) {
			if (p.getName().equals(input)) {
				return p;
			}
		}
		throw new IllegalArgumentException("[ERROR] 유효한 상품 이름을 입력하세요.");
	}

	public boolean isFinished(int inputCoin) {
		if (getMinimumPriceProduct() > inputCoin) {
			return true;
		}
		if (isNoProducts()) {
			return true;
		}
		return false;
	}

	public int getMinimumPriceProduct() {
		int minPrice = this.products.get(0).getPrice();
		for (Product p: products) {
			if (minPrice > p.getPrice()) {
				minPrice = p.getPrice();
			}
		}
		return minPrice;
	}

	public boolean isNoProducts() {
		for (Product p: products) {
			if (p.getCount() != 0) {
				return false;
			}
		}
		return true;
	}
}
