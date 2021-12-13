package vendingmachine;

public class Utils {
    public static void MachineOn() {
        int change = PrintUI.InputChange();
        Coin.SettingCoin(change);
    }
}
