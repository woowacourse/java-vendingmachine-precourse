package vendingmachine;

public class Juice {
    private String name;
    private int numberOfCan;
    private int price;

    Juice(String name, int price, int numberOfCan) {
        this.name = name;
        this.numberOfCan = numberOfCan;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getNumberOfCan() {
        return numberOfCan;
    }

    public String getName() {
        return name;
    }

    public int MinPrice(int minPrice) {
        return Math.min(this.price,minPrice);
    }
}
