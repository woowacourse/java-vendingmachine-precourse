package vendingmachine;

import java.util.Objects;

public class Juice {
    private String name;
    private int numberOfCan;
    private int price;

    Juice(String name, int price, int numberOfCan) {
        this.name = name;
        this.numberOfCan = numberOfCan;
        this.price = price;
    }

    public int MinPrice(int minPrice) {
        return Math.min(this.price,minPrice);
    }

    public int EqualJuiceName(String orderJuice) {
        if (Objects.equals(orderJuice, name)) {
            return price;
        }
        return 0;
    }

    public boolean OutPutOneJuice() {
        try {
            if (numberOfCan == 0) {
                throw new IllegalArgumentException();
            }
            numberOfCan -= 1;
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 재고가 소진되었습니다.");
            return false;
        }
    }
}
