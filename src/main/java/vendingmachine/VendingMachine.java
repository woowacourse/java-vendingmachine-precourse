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
	private CoinStocks coinStocks;
	private Products products;
	private int insertedMoney;

	public void operate() {
		setupMachine();
		sellUntilStop();
		returnMoney();
	}

	private void setupMachine() {
		coinStocks = new CoinStocks(setupChangeCoins());
		viewer.showCoins(coinStocks.toString());
		products = new Products(setupSellingProducts());
		setupMoney();
	}

	private void sellUntilStop() {
		while (products.anyAvailableRemain(insertedMoney)) {
			String customerInput = getCustomerInput();
			if (customerInput.equals(END_OPTION)) {
				break;
			}
			try {
				insertedMoney = products.sellProductAndDeductMoney(customerInput, insertedMoney);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void returnMoney() {
		CoinStocks returnCoinStocks = coinStocks.getReturnCoins(insertedMoney);
		viewer.showCoins(returnCoinStocks.toString());
	}

	private String getCustomerInput() {
		viewer.showRemainMoney(insertedMoney);
		return customerInput.getPurchaseName();
	}

	private List<CoinStock> setupChangeCoins() {
		int changes = machineInput.getTotalMachineChanges();
		RandomCoinSelector randomCoinSelector = new RandomCoinSelector();
		return randomCoinSelector.makeRandomCoinMix(changes);
	}

	public List<Product> setupSellingProducts() {
		List<Product> inputProducts = new ArrayList<>();
		try {
			List<String> inputProductsInfo = machineInput.getProductsInfo();
			inputProducts = makeProductsFromInfo(inputProductsInfo);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setupSellingProducts();
		}
		return inputProducts;
	}

	public void setupMoney() {
		try {
			insertedMoney = customerInput.getInsertedMoney();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setupMoney();
		}
	}

	private List<Product> makeProductsFromInfo(List<String> productsInfo) {
		ProductBuilder productBuilder = new ProductBuilder();
		List<Product> inputProducts = productsInfo.stream()
				.map(p -> productBuilder.makeProductFromInfo(p))
				.collect(Collectors.toList());
		checkNoDuplication(inputProducts);
		return inputProducts;
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
