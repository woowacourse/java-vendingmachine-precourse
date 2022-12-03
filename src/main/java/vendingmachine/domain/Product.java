package vendingmachine.domain;

public class Product {
    private final String name;
    private final int price;
    private final int RUN_OUT = -1;
    private int amount;


    public Product(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public int buyProduct(String name){
        if(this.name.equals(name)){
            amount--;
            return price;
        }
        return RUN_OUT;
    }
    public boolean isExistProduct(){
        if(amount == 0)return false;
        return true;
    }
}
