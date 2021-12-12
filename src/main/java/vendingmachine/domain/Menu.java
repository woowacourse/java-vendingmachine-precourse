package vendingmachine.domain;

import vendingmachine.view.InputView;

import static vendingmachine.utils.ExceptionMessages.SOLD_OUT_EXCEPTION;
import static vendingmachine.utils.ExceptionMessages.UNKNOWN_MERCHANDISE_NAME_EXCEPTION;

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

            if (merchandise.getNumber() == 0) {
                throw new IllegalArgumentException(SOLD_OUT_EXCEPTION);
            }
            return merchandise;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectAvailableMerchandise();
        }
    }

    public boolean hasSellableMerchandise(int moneyLeft) {
        boolean isEnoughMoney = false;
        for (Merchandise merchandise : this.merchandiseList) {
            if (merchandise.getNumber() == 0) continue;
            if (moneyLeft >= merchandise.getPrice()) {
                isEnoughMoney = true;
                break;
            }
        }
        return isEnoughMoney;
    }

    private Merchandise getMerchandiseByName(String name) {
        for (Merchandise merchandise : merchandiseList) {
            if (!merchandise.getName().equals(name)) continue;
            return merchandise;
        }
        throw new IllegalArgumentException(UNKNOWN_MERCHANDISE_NAME_EXCEPTION);
    }
}
