package vendingmachine.io;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.data.VendingMachineData;
import vendingmachine.io.validator.InputValidator;
import vendingmachine.type.Product;

public class InputHandler {

	OutputHandler outputHandler;

	private String read() {
		return Console.readLine();
	}

	public InputHandler(OutputHandler outputHandler) {
		this.outputHandler = outputHandler;
	}

	public int getValidMoney() {
		outputHandler.printMessage(VendingMachineData.INPUT_VENDING_MACHINE_MONEY_MESSAGE);
		return getMoney();
	}

	public List<Product> getValidProductList() {
		outputHandler.printMessage(VendingMachineData.INPUT_PRODUCT_INFO_MESSAGE);
		return getProductList();
	}

	private int getMoney() {
		String data = read();
		InputValidator.validMoneyValue(data);
		return Integer.parseInt(data);
	}

	private List<Product> getProductList() {
		String[] productData = read().split(";");
		InputValidator.validProductInformationForm(productData);
		List<Product> productList = generateProductList(productData);
		InputValidator.validNameNotDuplicate(productList);
		return productList;
	}

	private List<Product> generateProductList(String[] productData) {
		Pattern productPattern = Pattern.compile(VendingMachineData.PRODUCT_REGEX);
		List<Product> productList = new ArrayList<Product>();
		for (String product : productData) {
			Matcher matcher = productPattern.matcher(product);
			matcher.find();
			productList.add(
				new Product(matcher.group(1), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3))));
		}
		return productList;
	}
}
