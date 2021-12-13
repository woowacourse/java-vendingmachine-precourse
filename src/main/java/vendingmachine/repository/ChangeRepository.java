package vendingmachine.repository;

public class ChangeRepository {
    private static int change;

    public static int getChange() {
        return change;
    }

    public static void initChange(int change) {
        ChangeRepository.change = change;
    }

    public static void subtractChange(int productPrice) {
        change -= productPrice;
    }
}
