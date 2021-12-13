package vendingmachine.domain;

import java.util.List;

import static vendingmachine.constants.ExceptionMessages.UNKNOWN_MERCHANDISE_NAME_EXCEPTION;

public class Menu {

    private final List<Merchandise> merchandiseList;

    public Menu(List<Merchandise> merchandiseList) {
        this.merchandiseList = merchandiseList;
    }

    public List<Merchandise> getMerchandiseList() {
        return merchandiseList;
    }

    public Merchandise getMerchandiseByName(String name) {
        for (Merchandise merchandise : this.merchandiseList) {
            if (!merchandise.getName().equals(name)) continue;
            return merchandise;
        }
        throw new IllegalArgumentException(UNKNOWN_MERCHANDISE_NAME_EXCEPTION);
    }
}
