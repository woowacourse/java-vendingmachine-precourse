package vendingmachine.menu;

import java.util.HashMap;
import java.util.List;
import vendingmachine.exception.VendingMachineException;

public class Menus {
    HashMap<Menu, Integer> menus = new HashMap<>();

    public Menus(List<String> menusInputs) {
        validateListNotEmpty(menusInputs);
        menusInputs.stream()
                .map(input -> input.substring(1, input.length() - 1).split(","))
                .forEach(this::putMenu);
    }

    private void putMenu(String[] inputs) {
        String menuName = inputs[0];
        int menuPrice = Integer.parseInt(inputs[1]);
        int menuAmount = Integer.parseInt(inputs[2]);
        validateAmount(menuAmount);

        menus.put(Menu.of(menuName, menuPrice),
                menuAmount);
    }

    private void validateAmount(int menuAmount) {
        if (menuAmount < 1) {
            throw VendingMachineException.MENU_AMOUNT_MUST_POSITIVE.makeException();
        }
    }

    private void validateListNotEmpty(List<String> menusInputs) {
        if (menusInputs.isEmpty()) {
            throw VendingMachineException.EMPTY_MENU_LIST.makeException();
        }
    }

    public Menu getMenu(String menuName) {
        return menus.keySet().stream()
                .filter(key -> key.getName().equals(menuName))
                .findFirst()
                .orElseThrow(VendingMachineException.NO_MENU_FOUNDED::makeException);
    }

    public boolean isSoldOut() {
        return menus.isEmpty();
    }

    public int getMinPrice() {
        return menus.keySet().stream()
                .mapToInt(Menu::getPrice)
                .min()
                .getAsInt();
    }

    public void purchase(Menu menu) {
        Integer count = menus.get(menu);
        if (count <= 0) {
            throw VendingMachineException.CANT_PURCHASE.makeException();
        }
        if (count == 1) {
            menus.remove(menu);
            return;
        }

        menus.put(menu, menus.get(menu) - 1);
    }
}
