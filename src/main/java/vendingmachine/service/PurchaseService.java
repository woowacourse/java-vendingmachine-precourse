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
		if (catalog == null) {
			throw new IllegalArgumentException("존재하지 않는 상품명 입니다.");
		}
		int amount = catalog.getAmount();
		int price = catalog.getPrice();
		int userAccount = UserAccount.getAccount();
		if (price > userAccount) {
			throw new IllegalArgumentException("상품을 살 돈이 부족합니다.");
		}
		if (amount == NO_MORE_CATALOG) {
			throw new IllegalArgumentException("상품의 개수가 부족합니다.");
		}
		return catalog;
	}
}
