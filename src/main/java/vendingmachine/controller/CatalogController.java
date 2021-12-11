package vendingmachine.controller;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Catalog;
import vendingmachine.repository.CatalogRepository;
import vendingmachine.view.CatalogInputView;

public class CatalogController {

	public static void getCatalogListInput() {
		CatalogInputView.printInputGuide();

		String s = Console.readLine();
		List<String> catalogStringList = Arrays.asList(s.split(";"));

		for (String catalogString : catalogStringList) {
			String s1 = catalogString.replace("[", "").replace("]", "");
			List<String> result = Arrays.asList(s1.split(","));
			Catalog catalog = new Catalog(result.get(0), Integer.parseInt(result.get(1)), Integer.parseInt(result.get(2)));
			CatalogRepository.add(catalog);
		}

	}
}
