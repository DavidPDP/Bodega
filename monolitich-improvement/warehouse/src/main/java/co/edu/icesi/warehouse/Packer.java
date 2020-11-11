package co.edu.icesi.warehouse;

public class Packer extends Worker{
	
	private Warehouse warehouse;
	
	public Packer(String id, Warehouse warehouse) {
		super(id);
		this.warehouse = warehouse;
	}

	public void run() {
		while(true) {
			task();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void task() {
		try {
			warehouse.packPremiumProduct(super.getId());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
