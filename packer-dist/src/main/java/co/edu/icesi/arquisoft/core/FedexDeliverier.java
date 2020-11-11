package co.edu.icesi.arquisoft.core;

import co.edu.icesi.arquisoft.common.RawPackageType;
import co.edu.icesi.arquisoft.common.WarehouseServices;

public class FedexDeliverier extends Deliverier {
	
	private WarehouseServices warehouseServices;
	
	public FedexDeliverier(String id, WarehouseServices warehouseServices) {
		super(id);
		this.warehouseServices = warehouseServices;
	}

	@Override
	public void deliver() {
		warehouseServices.storeRawPackage(super.getId(), 
			RawPackageType.FEDEX_PACKAGE);
	}
	
}
