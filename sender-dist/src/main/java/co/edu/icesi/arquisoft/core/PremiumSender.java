package co.edu.icesi.arquisoft.core;

import co.edu.icesi.arquisoft.common.WarehouseServices;

public class PremiumSender extends Worker {
	
	private WarehouseServices warehouseServices;
	
	public PremiumSender(String id, WarehouseServices warehouseServices) {
		super(id);
		this.warehouseServices = warehouseServices;
	}

	@Override
	public void task() {
		try {
			super.addPackage(warehouseServices.sendPremiumProduct(super.getId()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
