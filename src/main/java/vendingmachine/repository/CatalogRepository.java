package vendingmachine.repository;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.Catalog;

public class CatalogRepository {
	private static final List<Catalog> catalogList = new ArrayList<>();

	public static void add(Catalog catalog) {
		catalogList.add(catalog);
	}

	public void printAll() {
		for (Catalog catalog : catalogList) {
			catalog.print();
		}
	}
}
