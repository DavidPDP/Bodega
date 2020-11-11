package co.edu.icesi.arquisoft.core;

import java.util.UUID;

import org.osoa.sca.annotations.Property;
import org.osoa.sca.annotations.Reference;

import co.edu.icesi.arquisoft.common.WarehouseServices;

public class EntryPoint implements Runnable {
	
	public final static String FEDEX_DELIVERIER = "FedexDeliverier";
	public final static String SERVIENTREGA_DELIVERIER = "ServientregaDeliverier";
	
	@Property
	private String deliverierType = FEDEX_DELIVERIER;
	
	@Reference
	private WarehouseServices warehouseServices;

	public void setDeliverierType(String deliverierType) {
		this.deliverierType = deliverierType;
	}
	
	public void setWarehouseServices(WarehouseServices warehouseServices) {
		this.warehouseServices = warehouseServices;
	}
	
	@Override
	public void run() {
		
		Deliverier deliverier = null;
		String deliverierId = UUID.randomUUID().toString();
		
		if(deliverierType.equals(FEDEX_DELIVERIER)) {
			deliverier = new FedexDeliverier(deliverierId, warehouseServices);
		}else {
			deliverier = new ServientregraDeliverier(deliverierId, warehouseServices);
		}
		
		while(true) {
			deliverier.deliver();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
