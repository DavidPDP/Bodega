package co.edu.icesi.arquisoft.core;

import java.util.UUID;

import org.osoa.sca.annotations.Init;
import org.osoa.sca.annotations.Property;
import org.osoa.sca.annotations.Reference;

import co.edu.icesi.arquisoft.common.WarehouseServices;

public class EntryPoint implements Runnable {

	public final static String PACKER_WORKER = "PackerWorker";
	public final static String PREMIUM_SENDER_WORKER = "PremiumSenderWorker";
	
	@Property
	private String workerType = PACKER_WORKER;
	
	@Reference
	private WarehouseServices warehouseServices;
	
	@Init
	public void test() {
		System.out.println("Soy un sender tipo: " + this.workerType);
	}
	
	public void setWorkerType(String workerType) {
		this.workerType = workerType;
	}
	
	public void setWarehouseServices(WarehouseServices warehouseServices) {
		this.warehouseServices = warehouseServices;
	}
	
	@Override
	public void run() {
		
		Worker worker = null;
		String workerId = UUID.randomUUID().toString();
		
		if(workerType.equals(PACKER_WORKER)) {
			worker = new Packer(workerId, warehouseServices);
		}else {
			worker = new PremiumSender(workerId, warehouseServices);
		}
		
		while(true) {
			worker.task();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
