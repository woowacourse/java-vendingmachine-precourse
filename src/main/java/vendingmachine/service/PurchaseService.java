package vendingmachine.service;

import static vendingmachine.service.exception.InputExceptionService.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Catalog;
import vendingmachine.domain.UserAccount;
import vendingmachine.repository.CatalogRepository;
import vendingmachine.view.exception.ErrorMessage;

public class PurchaseService {
	private static final int NO_MORE_CATALOG = 0;

	public static boolean checkEndCondition() {
		int userAccount = UserAccount.getAccount();
		List<Catalog> catalogList = CatalogRepository.getCatalogs();

		for (Catalog catalog : catalogList) {
			int catalogPrice = catalog.getPrice();
			int catalogAmount = catalog.getAmount();
			if (catalogPrice <= userAccount
				&& catalogAmount != NO_MORE_CATALOG) {
				return false;
			}
		}
		return true;
	}

	public static Catalog getCatalogInput() {
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
