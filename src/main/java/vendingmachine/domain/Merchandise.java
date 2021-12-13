package vendingmachine.domain;

import static vendingmachine.constants.SystemConstants.*;

public class Merchandise {

    private String name;
    private int price;
    private int number;

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
