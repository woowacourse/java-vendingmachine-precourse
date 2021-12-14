package vendingmachine.product;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;

public class ProductController {
	private ProductStorage productStorage;
	private ProductMapper productMapper;
	private ProductStorageValidator productStorageValidator;
	private ProductValidator productValidator;

	public ProductController() {
		productStorage = new ProductStorage();
		productMapper = new ProductMapper();
		productStorageValidator = new ProductStorageValidator();
		productValidator = new ProductValidator();
	}

	public ProductStorage readyToProductStorage() {
		InputView.printInitialProductSettingMessage();
		requestInitialProducts();
		return productStorage;
	}

	private void requestInitialProducts() {
		try {
			String inputProducts = Console.readLine();
			productStorageValidator.validate(inputProducts);
			productStorage.storeProducts(inputProducts, productMapper, productValidator);
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.printMessage(illegalArgumentException);
			requestInitialProducts();
		}
	}
}
