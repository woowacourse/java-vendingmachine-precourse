package vendingmachine.domain;

import static vendingmachine.constants.SystemConstants.*;
import static vendingmachine.utils.StringFormatUtils.*;

public class Merchandise {

    private final String name;
    private final int price;
    private int number;

    public Merchandise(String merchandiseInfo) {
        String[] infoList = trimBothEnds(merchandiseInfo).split(COMMA);
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
