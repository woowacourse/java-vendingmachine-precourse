package vendingmachine.item;

public class ItemKey {

    private String name;
    private Integer id = null;

    public static ItemKey fromName(String name) {
        ItemKey itemKey = new ItemKey();
        itemKey.name = name;
        return itemKey;
    }

    public String getName(){
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNullId() {
        return id == null;
    }
}