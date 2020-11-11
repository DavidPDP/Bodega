package co.edu.icesi.arquisoft.core;

import co.edu.icesi.arquisoft.common.WarehouseServices;

public class Packer extends Worker{
	
	private WarehouseServices warehouseServices;
	
	public Packer(String id, WarehouseServices warehouseServices) {
		super(id);
		this.warehouseServices = warehouseServices;
	}

	@Override
	public void task() {
		try {
			warehouseServices.packPremiumProduct(super.getId());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
