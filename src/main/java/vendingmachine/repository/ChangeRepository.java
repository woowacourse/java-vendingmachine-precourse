package vendingmachine.repository;

public class ChangeRepository {
    private static ChangeRepository instance = new ChangeRepository();
    private static int change;

    private ChangeRepository() {
    }

    public static ChangeRepository getInstance() {
        return instance;
    }

    public int getChange() {
        return change;
    }

    public void initChange(int change) {
        ChangeRepository.change = change;
    }

    public void subtractChange(int price) {
        change -= price;
    }
}
