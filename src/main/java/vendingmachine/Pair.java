package vendingmachine;

import java.util.List;

public class Pair {
    Integer price;
    List<Menu> menus;

    Pair(Integer price, List<Menu> menus) {
        this.price = price;
        this.menus = menus;
    }

    public Integer getPrice(){
        return this.price;
    }

    public List<Menu> getMenus(){
        return this.menus;
    }
}
