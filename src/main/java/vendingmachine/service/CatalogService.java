package vendingmachine.service;

import static vendingmachine.service.exception.InputExceptionService.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Catalog;
import vendingmachine.repository.CatalogRepository;
import vendingmachine.view.exception.ErrorMessage;

public class CatalogService {
	private static final String CATALOG_STRING_SPLITTER = ";";
	private static final String CATALOG_CATEGORY_SPLITTER = ",";
	private static final List<Catalog> INVALID_INPUT = null;

	public static void setCatalogListByInput() {
		List<Catalog> catalogList;
		do {
			String input = Console.readLine();
			catalogList = validateInput(input);
		} while (catalogList == INVALID_INPUT);
		setCatalogRepository(catalogList);
	}

	private static List<Catalog> validateInput(String input) {
		try {
			List<String> stringList = makeStringList(input);
			return makeCatalogList(stringList);
		} catch (IllegalArgumentException e) {
			ErrorMessage.print(e.getMessage());
			return INVALID_INPUT;
		}
	}

	private static void setCatalogRepository(List<Catalog> catalogList) {
		for (Catalog catalog : catalogList) {
			CatalogRepository.join(catalog);
		}
	}

	private static List<Catalog> makeCatalogList(List<String> catalogStringList) {
		List<Catalog> catalogList = new ArrayList<>();
		for (String catalogString : catalogStringList) {
			Catalog catalog = makeCatalog(catalogString);
			checkCatalogAlreadyExist(catalogList, catalog);
			catalogList.add(catalog);
		}
		return catalogList;
	}

	private static Catalog makeCatalog(String catalogString) {
		List<String> splitResult = splitCatalogString(catalogString);

		String name = splitResult.get(0);
		int price = parsePriceToInt(splitResult.get(1));
		int amount = parseAmountToInt(splitResult.get(2));

		return new Catalog(name, price, amount);
	}

	private static int parseAmountToInt(String stringAmount) {
		int amount = parseToInt(stringAmount);
		checkZeroOrPositiveInt(amount);
		return amount;
	}

	private static int parsePriceToInt(String priceString) {
		int price = parseToInt(priceString);
		checkModTen(price);
		checkZeroOrPositiveInt(price);
		checkMinimumPrice(price);
		return price;
	}

	private static List<String> splitCatalogString(String catalogString) {
		String stringBracedOff = catalogString.substring(1, catalogString.length() - 1);
		List<String> splitResult = Arrays.asList(stringBracedOff.split(CATALOG_CATEGORY_SPLITTER));
		checkCatalogSize(splitResult.size());
		for (String input : splitResult) {
			checkEmptyString(input);
		}
		return splitResult;
	}

	private static List<String> makeStringList(String inputString) {
		checkEndWithSemiColon(inputString);
		List<String> catalogStringList = Arrays.asList(inputString.split(CATALOG_STRING_SPLITTER));
		for (String catalogString : catalogStringList) {
			checkCatalogFormat(catalogString);
		}
		return catalogStringList;
	}

}
