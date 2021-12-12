package vendingmachine.repository;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.Catalog;

public class CatalogRepository {
	private static final List<Catalog> catalogList = new ArrayList<>();

	public static void join(Catalog catalog) {
		catalogList.add(catalog);
	}
}
