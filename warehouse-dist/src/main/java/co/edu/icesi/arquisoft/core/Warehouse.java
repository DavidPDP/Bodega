package co.edu.icesi.arquisoft.core;

import java.util.EnumSet;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import co.edu.icesi.arquisoft.common.PremiumProduct;
import co.edu.icesi.arquisoft.common.RawPackageType;
import co.edu.icesi.arquisoft.common.WarehouseServices;

public class Warehouse implements WarehouseServices {
	
	public static final int CAPACITY = 200;
	public static final String LOCATION = "Cali";
	
	private int currentCapacity;
	private Object lockStore;
	private Object lockPack;
	private Object lockSend;
	
	private BlockingQueue<PremiumProduct> toDespatch;
	private EnumSet<RawPackageType> packages;
	
	public Warehouse() {
		toDespatch = new ArrayBlockingQueue<PremiumProduct>(Warehouse.CAPACITY);
		packages = EnumSet.noneOf(RawPackageType.class);
		lockStore = new Object();
		lockPack = new Object();
		lockSend = new Object();
	}
	
	private int getCurrentCapacity() {
		return currentCapacity;
	}
	
    private void freeUpSpace(int volume) {
		currentCapacity -= volume;
	}
    
    private void fillSpace(int volume) {
		currentCapacity += volume;
    }
	
    @Override
	public void storeRawPackage(String id, RawPackageType type) {
		synchronized (lockStore) {
			if(type.amount() <= Warehouse.CAPACITY * 
					type.distribution()/type.volume()) {
				fillSpace(type.volume());
				type.increment();
				packages.add(type);
				System.out.println("Delivery: " + id 
						+ " store: " + type.type() 
						+ " volume: " + type.volume() 
						+ " warehouse capacity: " + this.getCurrentCapacity()
						+ " fedex stock: " 
						+ RawPackageType.FEDEX_PACKAGE.amount()
						+ " servientrega stock: " 
						+ RawPackageType.SERVIENTREGA_PACKAGE.amount());
			}
		}
	}
	
    @Override
	public void packPremiumProduct(String id) throws InterruptedException {
		synchronized (lockPack) {
			if(RawPackageType.FEDEX_PACKAGE.amount() >= 
					PremiumProduct.PACKAGE_1_AMOUNT && 
					RawPackageType.SERVIENTREGA_PACKAGE.amount() >= 
					PremiumProduct.PACKAGE_2_AMOUNT) {
				PremiumProduct newPackage = 
						new PremiumProduct(UUID.randomUUID().toString(), 
								Warehouse.LOCATION, "CENDIS");
				RawPackageType.FEDEX_PACKAGE.decrement(4);
				RawPackageType.SERVIENTREGA_PACKAGE.decrement(3);
				toDespatch.put(newPackage);
				System.out.println("Worker: " + id + " new product!");
			}
		}
	}
	
    @Override
	public PremiumProduct sendPremiumProduct(String id) throws InterruptedException {
		PremiumProduct premiumPackage = toDespatch.take();
		synchronized (lockSend) {
			freeUpSpace(premiumPackage.getVolume());
			System.out.println("Worker: " + id + " send volume: " 
					+ premiumPackage.getVolume() + " warehouse capacity: " 
					+ this.getCurrentCapacity());
			return premiumPackage;
		}
	}
	
}
