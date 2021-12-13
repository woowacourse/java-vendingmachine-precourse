package vendingmachine.service;

import static vendingmachine.service.exception.InputExceptionService.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Catalog;
import vendingmachine.domain.UserAccount;
import vendingmachine.repository.CatalogRepository;
import vendingmachine.view.exception.ErrorMessage;

public class PurchaseService {

	public static boolean checkEndCondition() {
		int userAccount = UserAccount.getAccount();
		List<Catalog> catalogList = CatalogRepository.getCatalogs();

		for (Catalog catalog : catalogList) {
			if(catalog.isCheaperThan(userAccount)
				&& catalog.isExist()){
				return false;
			}
		}
		return true;
	}

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

	public static void purchase(Catalog catalogToPurchase) {
		UserAccount.purchase(catalogToPurchase);
		CatalogRepository.reduceAmount(catalogToPurchase);
	}
}
