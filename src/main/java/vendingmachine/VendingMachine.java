package vendingmachine;

import vendingmachine.firstclass.CoinStocks;
import vendingmachine.firstclass.Products;
import vendingmachine.input.CustomerInput;
import vendingmachine.input.MachineInput;
import vendingmachine.model.CoinStock;
import vendingmachine.model.Product;
import vendingmachine.util.ProductBuilder;
import vendingmachine.util.RandomCoinSelector;
import vendingmachine.view.MachineViewer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static vendingmachine.message.Error.*;

public class VendingMachine {

	private static final String END_OPTION = "잔돈";

	private MachineInput machineInput = new MachineInput();
	private CustomerInput customerInput = new CustomerInput();
	private MachineViewer viewer = new MachineViewer();
	private List<CoinStock> coins = new ArrayList<>();
	private int money = 0;

	public void run() {
		operate();
	}

	public void operate() {
		CoinStocks coinStocks = setupChangeCoins();
		viewer.showCoins(coinStocks.toString());
		Products products = new Products(setupSellingProducts());
		setupMoney();
		while (products.anyAvailableRemain(money)) {
			String customerInput = getCustomerInput();
			if (customerInput.equals(END_OPTION)) {
				break;
			}
			try {
				money = products.sellProduct(customerInput, money);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		CoinStocks returnCoinStocks = coinStocks.getReturnCoins(money);
		viewer.showCoins(returnCoinStocks.toString());
	}

	private String getCustomerInput() {
		viewer.showRemainMoney(money);
		return customerInput.getPurchaseName();
	}

	private CoinStocks setupChangeCoins() {
		int changes = machineInput.getTotalMachineChanges();
		RandomCoinSelector randomCoinSelector = new RandomCoinSelector();
		return new CoinStocks(randomCoinSelector.makeRandomCoinMix(changes));
	}

	public List<Product> setupSellingProducts() {
		List<Product> products = new ArrayList<>();
		try {
			List<String> productsInfo = machineInput.getProductsInfo();
			products = makeProductsFromInfo(productsInfo);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setupSellingProducts();
		}
		return products;
	}

	public void setupMoney() {
		try {
			money = customerInput.getInsertedMoney();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setupMoney();
		}
	}

	private List<Product> makeProductsFromInfo(List<String> productsInfo) {
		ProductBuilder productBuilder = new ProductBuilder();
		List<Product> products = productsInfo.stream()
				.map(p -> productBuilder.makeProductFromInfo(p))
				.collect(Collectors.toList());
		checkNoDuplication(products);
		return products;
	}

	private void checkNoDuplication(List<Product> products) {
		boolean duplicate = products.stream()
				.map(Product::getName)
				.distinct()
				.count() != products.size();
		if (duplicate) {
			throw new IllegalArgumentException(DUPLICATED_PRODUCT_NAME);
		}
	}
}
