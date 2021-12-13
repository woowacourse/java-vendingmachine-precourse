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
}
