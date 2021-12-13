package vendingmachine.model;

import vendingmachine.validator.MachineValidator;

public class Machine {
    private final MachineValidator validator = new MachineValidator();

    private CoinBox coinBox;
    private ProductTable productTable;

    private int asset;
    private int inputMoney;

    public Machine() {
    }

    public void setInitialAsset(int asset) {
        coinBox = new CoinBox();
        coinBox.generateRandomCoinBox(validator.checkAsset(asset));
        this.asset = coinBox.getValueOfCoinBox();
    }

    public void setProductTable(ProductTable productTable) {
        this.productTable = productTable;
    }

    public CoinBox getCoinBox() {
        return coinBox;
    }

    public int getInputMoney() {
        return inputMoney;
    }

    public void setInputMoney(int inputMoney) {
        validator.checkAsset(inputMoney);
        this.inputMoney = inputMoney;
    }

    public void addInputMoney(int inputMoney) {
        validator.checkAsset(inputMoney);
        this.inputMoney += inputMoney;
    }
}
