package co.edu.icesi.warehouse;

public class PremiumSender extends Worker {
	
	private Warehouse warehouse;
	
	public PremiumSender(String id, Warehouse warehouse) {
		super(id);
		this.warehouse = warehouse;
	}

	public void run() {
		while(true) {
			task();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void task() {
		try {
			super.addPackage(warehouse.sendPremiumProduct(super.getId()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
