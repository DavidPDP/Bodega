package co.edu.icesi.arquisoft.common;

import org.osoa.sca.annotations.Service;

@Service
public interface WarehouseServices {

	public void storeRawPackage(String id, RawPackageType type);
	
	public void packPremiumProduct(String id) throws InterruptedException;
	
	public PremiumProduct sendPremiumProduct(String id) throws InterruptedException;
	
}
