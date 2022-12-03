package vendingmachine;

public class Product {
    String NAME;
    String PRICE;
    String COUNT;

    public Product(String name, String price, String count) {
        NAME = name;
        PRICE = price;
        COUNT = count;
    }
    public String getname(){
        return NAME;
    }
    public int getprice(){
        return Integer.parseInt(PRICE);
    }
    public String getcount() {
        return COUNT;
    }
}
