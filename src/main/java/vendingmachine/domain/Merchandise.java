package vendingmachine.domain;

import static vendingmachine.constants.SystemConstants.*;

public class Merchandise {

    public String name;
    public int price;
    public int number;

    public Merchandise(String merchandiseInfo) {
        String[] infoList = merchandiseInfo.substring(1, merchandiseInfo.length() - 1).split(",");
        this.name = infoList[NAME_IDX];
        this.price = Integer.parseInt(infoList[PRICE_IDX]);
        this.number = Integer.parseInt(infoList[NUMBER_IDX]);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public void decreaseNumber() {
        this.number--;
    }
}
