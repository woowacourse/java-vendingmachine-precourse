package vendingmachine.view;

import java.util.ArrayList;

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

	public String inputAmountOfMoney() {
		System.out.println(VendingMachineMessage.INPUT_AMOUNT_MONEY_IN_MACHINE);
		return Console.readLine();
	}

	public String inputProductsInformation() {
		System.out.print("\n");
		System.out.println(VendingMachineMessage.INPUT_PRODUCTS_INFORMATION);
		return Console.readLine();
	}

	public String inputMoney() {
		System.out.print("\n");
		System.out.println(VendingMachineMessage.INPUT_MONEY);
		return Console.readLine();
	}

	public String selectProduct() {
		System.out.println(VendingMachineMessage.SELECT_PRODUCT_TO_PURCHASE);
		return Console.readLine();
	}
}
