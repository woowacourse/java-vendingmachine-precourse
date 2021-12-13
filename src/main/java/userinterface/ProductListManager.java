package userinterface;

import camp.nextstep.edu.missionutils.Console;
import utils.validator.IsAmount;
import vendingmachine.Product;
import vendingmachine.Products;

public class ProductListManager {
	private Products productList;

	public Products getList() {
		return productList;
	}

	public ProductListManager() {
		System.out.println();
		System.out.println("상품명과 가격, 수량을 입력해 주세요.");
		initProductList();
	}

	// 입력 자체로 에러를 판단할 수 없어 InputManager() 클래스를 사용하지 않는다.
	private void initProductList() {
		boolean passed = false;

		while (!passed) {
			try {
				productList = new Products();
				splitInputToProductDetail();
				passed = true;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	private void splitInputToProductDetail() {
		String input = Console.readLine();
		for (String productDetailRaw : input.split(";")) {
			splitProductDetailAsFactor(productDetailRaw);
		}
	}

	private void splitProductDetailAsFactor(String productDetailRaw) {
		String productDetail = trimBracket(productDetailRaw);
		String[] namePriceRemain = productDetail.split(",");
		addProductToList(namePriceRemain);
	}

	private String trimBracket(String string) {
		return string
			.replace("[", "")
			.replace("]", "");
	}

	private void addProductToList(String[] namePriceRemain) {
		String name = namePriceRemain[0];
		String price = namePriceRemain[1];
		String remain = namePriceRemain[2];

		if (checkValidations(name, price, remain)) {
			int priceInt = Integer.parseInt(price);
			int remainInt = Integer.parseInt(remain);
			Product product = new Product(name, priceInt);
			productList.put(product, remainInt);
		}
	}

	private boolean checkValidations(String name, String price, String remain) {
		IsAmount isAmount = new IsAmount();

		return (isNotDuplicate(name)
			&& isAmount.run(new StringBuilder(price))
			&& isAmount.run(new StringBuilder(remain)));
	}

	private boolean isNotDuplicate(String name) {
		productList.keySet().forEach(product -> {
			if (product.toString().equals(name)) {
				throw new IllegalArgumentException("[ERROR] 상품 이름이 중복되었습니다.");
			}
		});
		return true;
	}
}
