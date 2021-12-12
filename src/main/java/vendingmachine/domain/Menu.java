package vendingmachine.domain;

import java.util.List;

public class Menu {
    List<Merchandise> merchandiseList;

    public Menu(List<Merchandise> merchandiseList) {
        this.merchandiseList = merchandiseList;
    }
}
