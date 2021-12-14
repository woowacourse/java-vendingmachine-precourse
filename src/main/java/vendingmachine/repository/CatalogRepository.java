package vendingmachine.repository;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.Catalog;

public class CatalogRepository {
	private static final List<Catalog> catalogList = new ArrayList<>();

	public static void join(Catalog catalog) {
		catalogList.add(catalog);
	}

	public static Catalog getCatalogByName(String catalogName) {
		Catalog temporaryCatalog = new Catalog(catalogName, 0, 0);
		for (Catalog catalog : catalogList) {
			if (catalog.equals(temporaryCatalog)) {
				return catalog;
			}
		}
		return null;
	}

	public static void reduceAmount(Catalog catalogToPurchase) {

		Catalog catalog = getCatalogByName(catalogToPurchase.getName());
		if (catalog != null) {
			catalog.purchase();
		}
	}

	public static boolean isExistCheaperThan(int account) {
		for (Catalog catalog : catalogList) {
			if (catalog.isCheaperThan(account)
				&& catalog.isExist()) {
				return true;
			}
		}
		return false;
	}
}
