package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public int InputMachineCoin(){
        String machineCoinString = Console.readLine();
        return Integer.parseInt(machineCoinString);
    }
}
