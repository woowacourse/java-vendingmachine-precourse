package vendingmachine.model;

import vendingmachine.validator.MachineValidator;

public class Machine {
    private final MachineValidator validator = new MachineValidator();

    private CoinBox coinBox;
    private ProductTable productTable;

    private int asset;

    public Machine() {
    }

    public void setInitialAsset(int asset) {
        this.asset = validator.checkAsset(asset);
        coinBox = new CoinBox();
        coinBox.generateRandomCoinBox(asset);
    }

    public void setProductTable(ProductTable productTable) {
        this.productTable = productTable;
    }

}
