package vendingmachine.model;

import vendingmachine.validator.MachineValidator;

import static camp.nextstep.edu.missionutils.test.Assertions.*;

public class Machine {
    private final MachineValidator validator = new MachineValidator();
    private final Coins coins = new Coins();

    private int asset;

    public Machine() {
    }

    public void setInitialAsset(int asset) {
        validator.checkAsset(asset);
        this.asset = asset;
    }

    private void setCoins(int asset) {

    }
}
