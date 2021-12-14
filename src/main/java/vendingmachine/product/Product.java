package vendingmachine.product;

public class Product {
    private String name;
    private int price;
    private int stock;

    public Product(String name,int price,int stock){
        this.name=name;
        this.price=price;
        this.stock=stock;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public boolean isSame(String productName){
        return productName.equals(name);
    }

    public void buy(){
        stock-=1;
    }
}
