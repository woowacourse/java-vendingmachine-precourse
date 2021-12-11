package vendingmachine.product;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;

public class ProductController {
	private ProductStorage productStorage;
	private ProductMapper productMapper;
	private ProductValidator productValidator;

	public ProductController() {
		productStorage = new ProductStorage();
		productMapper = new ProductMapper();
		productValidator = new ProductValidator();
	}

	public ProductStorage readyToProductStorage() {
		InputView.printInitialProductSettingMessage();
		requestInitialProducts();
		return productStorage;
	}

	private void requestInitialProducts() {
		try {
			productStorage.storeProducts(Console.readLine(), productMapper, productValidator);
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.showMessage(illegalArgumentException);
			requestInitialProducts();
		}
	}
}
