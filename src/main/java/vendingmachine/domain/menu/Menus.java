package vendingmachine.domain.menu;

import java.util.List;
import vendingmachine.domain.money.Cash;
import vendingmachine.exception.VendingMachineException;

public class Menus {
    private final List<Menu> menus;

    public Menus(List<Menu> menus) {
        validateMenus(menus);
        this.menus = menus;
    }

    private void validateMenus(List<Menu> menus) {
        validateNotEmpty(menus);
        validateDuplicatedMenu(menus);
    }

    private void validateNotEmpty(List<Menu> menus) {
        if (menus.isEmpty()) {
            throw VendingMachineException.EMPTY_MENU.makeException();
        }
    }

    private void validateDuplicatedMenu(List<Menu> menus) {
        int distinctSize = (int) menus.stream()
                .distinct()
                .count();
        if (menus.size() != distinctSize) {
            throw VendingMachineException.DUPLICATED_MENU.makeException();
        }
    }

    public boolean canPurchase(Cash cash) {
        return menus.stream()
                .anyMatch(menu -> menu.canPurchase(cash));
    }

    public void purchase(String name, Cash cash) {
        Menu selectedMenu = getMenuByName(name);
        selectedMenu.purchase(cash);
    }

    private Menu getMenuByName(String name) {
        return menus.stream()
                .filter(menu -> menu.getName().equals(name))
                .findFirst()
                .orElseThrow(VendingMachineException.NO_SUCH_MENU::makeException);
    }
}
