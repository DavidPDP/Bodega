package co.edu.icesi.arquisoft.core;

import co.edu.icesi.arquisoft.common.RawPackageType;
import co.edu.icesi.arquisoft.common.WarehouseServices;

public class ServientregraDeliverier extends Deliverier {
	
	private WarehouseServices warehouseServices;
	
	public ServientregraDeliverier(String id, WarehouseServices warehouseServices) {
		super(id);
		this.warehouseServices = warehouseServices;
	}
	
	@Override
	public void deliver() {
		warehouseServices.storeRawPackage(super.getId(), 
			RawPackageType.SERVIENTREGA_PACKAGE);
	}
	
}
