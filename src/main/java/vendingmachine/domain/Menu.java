package vendingmachine.domain;

import java.util.List;

public class Menu {

    private List<Merchandise> merchandiseList;

    public Menu(List<Merchandise> merchandiseList) {
        this.merchandiseList = merchandiseList;
    }

    public List<Merchandise> getMerchandiseList() {
        return merchandiseList;
    }
}
