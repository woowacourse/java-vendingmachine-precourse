package vendingmachine.domain;

import java.util.List;

public class Menu {
    List<Merchandise> merchandiseList;

    public Menu(List<Merchandise> merchandiseList) {
        this.merchandiseList = merchandiseList;
    }

    public Merchandise getMerchandiseByName(String name) {
        for (Merchandise merchandise : merchandiseList) {
            if (!merchandise.getName().equals(name)) continue;
            return merchandise;
        }
        throw new IllegalArgumentException();
    }
}
