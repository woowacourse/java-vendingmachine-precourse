package vendingmachine.service;

import static vendingmachine.constants.ExceptionMessages.*;
import static vendingmachine.constants.SystemConstants.*;

import vendingmachine.domain.Menu;
import vendingmachine.domain.Merchandise;
import vendingmachine.view.InputView;

public class MenuService {

    private Menu menu;

    public void initializeMenu() {
        this.menu = InputView.getMenuInput();
    }

    public Merchandise selectAvailableMerchandise(int moneyLeft) {
        try {
            String name = InputView.getPurchaseInfoInput();
            Merchandise merchandise = this.getMerchandiseByName(name);

            if (merchandise.getPrice() > moneyLeft) throw new IllegalArgumentException();
            if (merchandise.getNumber() == NO_MERCHANDISE_LEFT) throw new IllegalArgumentException(SOLD_OUT_EXCEPTION);
            return merchandise;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectAvailableMerchandise(moneyLeft);
        }
    }

    public boolean hasSellableMerchandise(int moneyLeft) {
        boolean sellableMerchandiseExists = false;
        for (Merchandise merchandise : menu.getMerchandiseList()) {
            if (merchandise.getNumber() == NO_MERCHANDISE_LEFT) continue;
            if (moneyLeft >= merchandise.getPrice()) {
                sellableMerchandiseExists = true;
                break;
            }
        }
        return sellableMerchandiseExists;
    }

    private Merchandise getMerchandiseByName(String name) {
        for (Merchandise merchandise : menu.getMerchandiseList()) {
            if (!merchandise.getName().equals(name)) continue;
            return merchandise;
        }
        throw new IllegalArgumentException(UNKNOWN_MERCHANDISE_NAME_EXCEPTION);
    }
}
