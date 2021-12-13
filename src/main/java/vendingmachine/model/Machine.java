package vendingmachine.model;

import vendingmachine.validator.MachineValidator;

public class Machine {
    private final MachineValidator validator = new MachineValidator();
    private final CoinBox coinBox = new CoinBox();

    private ProductTable productTable = new ProductTable();

    private int asset;

    public Machine() {
    }

    public void setInitialAsset(int asset) {
        this.asset = validator.checkAsset(asset);
    }

    public void setProductTable(ProductTable productTable) {
        this.productTable = productTable;
    }

}
