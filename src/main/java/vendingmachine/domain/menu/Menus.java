package vendingmachine.domain.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Menus {
	private static final String ERROR_DELIMITERS = "[ERROR] 각 상품 정보는 세미콜론(;)으로 구분합니다.";
	private static final String DELIMITER = ";";

	private final List<Menu> menuList;

	public Menus(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public static Menus from(String menuInfos) {
		List<Menu> menuList = new ArrayList<>();
		validateMenuInfos(menuInfos);

		Arrays.stream(menuInfos.split(DELIMITER))
			.forEach(menuInfo -> menuList.add(Menu.from(menuInfo)));

		return new Menus(menuList);
	}

	private static void validateMenuInfos(String menuInfos) {
		if (!menuInfos.matches("([^;]+;)*[^;]+")) {
			throw new IllegalArgumentException(ERROR_DELIMITERS);
		}
	}

	public int getMinMenuPrice() {
		List<Integer> priceList = menuList.stream()
			.map(Menu::getPrice)
			.collect(Collectors.toList());
		return Collections.min(priceList);
	}

	public boolean isAnyMenuLeft() {
		return menuList.stream().anyMatch(menu -> menu.getCount() > 0);
	}
}
