package co.edu.icesi.warehouse;

public class FedexDeliverier extends Deliverier{
	
	private Warehouse warehouse;
	
	public FedexDeliverier(String id, Warehouse warehouse) {
		super(id);
		this.warehouse = warehouse;
	}
	
	public void run() {
		while(true) {
			deliver();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deliver() {
		warehouse.storeRawPackage(super.getId(), 
				RawPackageType.FEDEX_PACKAGE);
	}
}
