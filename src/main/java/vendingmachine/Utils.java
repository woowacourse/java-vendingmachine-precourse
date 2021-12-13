package vendingmachine;

public class Utils {
    public static void MachineOn() {
        CheckChange();
        String[] juices = PrintUI.InputJuice();
    }

    public static void CheckChange() {
        int change = PrintUI.InputChange();
        Coin.SettingCoin(change);
        Coin.PrintNumberOfCoin();
    }
}
