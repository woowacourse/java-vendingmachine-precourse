package vendingmachine.domain;

import static vendingmachine.utils.ExceptionMessages.*;
import static vendingmachine.constants.Constants.*;

import vendingmachine.view.InputView;

import java.util.List;

public class Menu {

    List<Merchandise> merchandiseList;

    public Menu(List<Merchandise> merchandiseList) {
        this.merchandiseList = merchandiseList;
    }

    public Merchandise selectAvailableMerchandise() {
        try {
            String name = InputView.getMerchandiseNameInput();
            Merchandise merchandise = this.getMerchandiseByName(name);

            if (merchandise.getNumber() == NO_MERCHANDISE_LEFT) {
                throw new IllegalArgumentException(SOLD_OUT_EXCEPTION);
            }
            return merchandise;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectAvailableMerchandise();
        }
    }

    public boolean hasSellableMerchandise(int moneyLeft) {
        boolean sellableMerchandiseExists = false;
        for (Merchandise merchandise : this.merchandiseList) {
            if (merchandise.getNumber() == NO_MERCHANDISE_LEFT) continue;
            if (moneyLeft >= merchandise.getPrice()) {
                sellableMerchandiseExists = true;
                break;
            }
        }
        return sellableMerchandiseExists;
    }

    private Merchandise getMerchandiseByName(String name) {
        for (Merchandise merchandise : merchandiseList) {
            if (!merchandise.getName().equals(name)) continue;
            return merchandise;
        }
        throw new IllegalArgumentException(UNKNOWN_MERCHANDISE_NAME_EXCEPTION);
    }
}
