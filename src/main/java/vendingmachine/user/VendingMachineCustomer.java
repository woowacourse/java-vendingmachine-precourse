package vendingmachine.user;

import vendingmachine.job.DepositJob;
import vendingmachine.job.PurchaseJob;

public class VendingMachineCustomer implements Customer {

	private final DepositJob depositJob;
	private final PurchaseJob purchaseJob;

	public VendingMachineCustomer(DepositJob depositJob, PurchaseJob purchaseJob) {
		this.depositJob = depositJob;
		this.purchaseJob = purchaseJob;
	}

	@Override
	public void purchase() {
		depositJob.execute();
		purchaseJob.execute();
	}
}
