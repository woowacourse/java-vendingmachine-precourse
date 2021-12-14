package vendingmachine.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

import vendingmachine.models.Product;
import vendingmachine.utils.VendingMachineMessage;

/**
 * <h1>자판기 구동에 필요한 정보를 입력받는다</h1>
 * 자판기 구동에 필요한 정보를 입력받아 컨트롤러에 넘긴다
 *
 * @author yunki kim
 * @version 1.1
 * @since 2021-12-12(V1.0)
 */

public class VendingMachineInput {

	private final ArrayList<Product> products;

	public VendingMachineInput(final ArrayList<Product> products) {
		this.products = products;
	}

	public int inputAmountOfMoney() {
		System.out.println(VendingMachineMessage.INPUT_AMOUNT_MONEY_IN_MACHINE);
		final String inputtedData = Console.readLine();
		return Integer.parseInt(inputtedData);
	}

	private ArrayList<Product> parseProductsInformation(final String productsInformation) {
		final List<String> productsList = Arrays
			.stream(productsInformation.split(";"))
			.collect(Collectors.toList());
		productsList.forEach(product -> {
			final String[] productString = product.substring(1, product.length() - 1)
				.split(",");
			final String name = productString[0];
			final Integer price = Integer.parseInt(productString[1]);
			final Integer amount = Integer.parseInt(productString[2]);
			products.add(new Product(name, price, amount));
		});
		return products;
	}

	public ArrayList<Product> inputProductsInformation() {
		System.out.print("\n");
		System.out.println(VendingMachineMessage.INPUT_PRODUCTS_INFORMATION);
		final String productsInformation = Console.readLine();
		return parseProductsInformation(productsInformation);
	}

	public int inputMoney() {
		System.out.print("\n");
		System.out.println(VendingMachineMessage.INPUT_MONEY);
		final String inputtedMoney = Console.readLine();
		return Integer.parseInt(inputtedMoney);
	}

	public String selectProduct() {
		System.out.println(VendingMachineMessage.SELECT_PRODUCT_TO_PURCHASE);
		return Console.readLine();
	}
}
