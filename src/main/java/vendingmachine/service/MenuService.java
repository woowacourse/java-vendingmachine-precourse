package vendingmachine.service;

import static vendingmachine.constants.SystemConstants.*;
import static vendingmachine.utils.MenuInputFormatValidator.validateMenuInputFormat;
import static vendingmachine.utils.PurchaseValidator.*;

import vendingmachine.domain.Menu;
import vendingmachine.domain.Merchandise;
import vendingmachine.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

    private Menu menu;

    public void initializeMenu() {
        this.menu = this.getMenuInput();
    }

    private Menu getMenuInput() {
        try {
            String menuInput = InputView.requestMenuInput();
            validateMenuInputFormat(menuInput);

            return generateMenu(menuInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMenuInput();
        }
    }

    private Menu generateMenu(String menuInput) {
        String[] merchandiseInfos = menuInput.split(SEMICOLON);

        List<Merchandise> merchandiseList = new ArrayList<>();
        for (String merchandiseInfo : merchandiseInfos) {
            merchandiseList.add(new Merchandise(merchandiseInfo));
        }
        return new Menu(merchandiseList);
    }

    public Merchandise selectAvailableMerchandise(int moneyLeft) {
        try {
            String name = InputView.getPurchaseInfoInput();
            Merchandise merchandise = this.menu.getMerchandiseByName(name);

            validateAvailableMerchandise(merchandise, moneyLeft);
            return merchandise;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectAvailableMerchandise(moneyLeft);
        }
    }

    public boolean hasSellableMerchandise(int moneyLeft) {
        boolean sellableMerchandiseExists = false;
        for (Merchandise merchandise : this.menu.getMerchandiseList()) {
            if (merchandise.getNumber() == NO_MERCHANDISE_LEFT) continue;
            if (moneyLeft >= merchandise.getPrice()) {
                sellableMerchandiseExists = true;
                break;
            }
        }
        return sellableMerchandiseExists;
    }
}
