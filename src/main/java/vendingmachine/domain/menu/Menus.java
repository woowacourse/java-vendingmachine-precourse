package vendingmachine.domain.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Menus {
	private static final String ERROR_DELIMITERS = "각 상품 정보는 세미콜론(;)으로 구분합니다.";
	private static final String ERROR_DUPLICATION = "상품명은 중복될 수 없습니다.";
	private static final String ERROR_NOT_FIND = "존재하지 않는 상품입니다.";
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
		validateDuplication(menuList);

		return new Menus(menuList);
	}

	private static void validateMenuInfos(String menuInfos) {
		validateFormat(menuInfos);
	}

	private static void validateFormat(String menuInfos) {
		if (!menuInfos.matches("([^;]+;)*[^;]+")) {
			throw new IllegalArgumentException(ERROR_DELIMITERS);
		}
	}

	private static void validateDuplication(List<Menu> menuList) {
		if (hasDuplicatedName(menuList)) {
			throw new IllegalArgumentException(ERROR_DUPLICATION);
		}
	}

	private static boolean hasDuplicatedName(List<Menu> menuList) {
		Set<String> menuNameSet = new HashSet<>();
		for (Menu menu : menuList) {
			menuNameSet.add(menu.getName());
		}
		return menuList.size() != menuNameSet.size();
	}

	public int getMinMenuPrice() {
		List<Integer> priceList = menuList.stream()
			.map(Menu::getPrice)
			.collect(Collectors.toList());
		return Collections.min(priceList);
	}

	public boolean isEveryMenuSoldOut() {
		return menuList.stream().allMatch(Menu::isSoldOut);
	}

	public Menu findMenuByName(String menuName) {
		return menuList.stream()
			.filter(menu -> menu.getName().equals(menuName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_FIND));
	}
}
