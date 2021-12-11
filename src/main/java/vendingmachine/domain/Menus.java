package vendingmachine.domain;

import java.util.List;

public class Menus {
	private final List<Menu> menuList;

	public Menus(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public static Menus from(String menuInfos) {
		return null;
	}
}
