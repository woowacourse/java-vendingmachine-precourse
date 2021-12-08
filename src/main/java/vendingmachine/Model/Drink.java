package vendingmachine.Model;

public class Drink {
    private String name;
    private int price;
    private int stock;

    public Drink(String name, int price, int stock){
        this.name=name;
        this.price=price;
        this.stock=stock;
    }

    public int isSameDrink(String drinkName){
        if(drinkName.equals(name)){
            return 1;
        }
        return 0;
    }

    public int getPrice(){
        return price;
    }

    public int getStock(){
        return stock;
    }
}
