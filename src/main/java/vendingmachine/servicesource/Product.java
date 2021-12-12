package vendingmachine.servicesource;

import java.util.Objects;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int  getPrice(){
        return price;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object object){

        if(object instanceof Product){
            return this.name == ((Product)object).name;
        }

        return false;
    }

}
