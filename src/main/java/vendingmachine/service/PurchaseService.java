package vendingmachine.service;

import static vendingmachine.service.exception.InputExceptionService.*;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Catalog;
import vendingmachine.repository.CatalogRepository;
import vendingmachine.view.exception.ErrorMessage;

public class PurchaseService {

	public static Catalog getValidCatalogInput() {
		try {
			String catalogName = Console.readLine();
			return getValidCatalog(catalogName);
		} catch (IllegalArgumentException e) {
			ErrorMessage.print(e.getMessage());
			return null;
		}
	}

	private static Catalog getValidCatalog(String input) {
		checkEmptyString(input);
		Catalog catalog = CatalogRepository.getCatalogByName(input);
		checkExistCatalog(catalog);
		checkCanPurchase(catalog);
		return catalog;
	}
}
