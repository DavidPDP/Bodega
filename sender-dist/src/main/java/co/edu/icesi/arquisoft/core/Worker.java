package co.edu.icesi.arquisoft.core;

import java.util.ArrayList;
import java.util.List;

import co.edu.icesi.arquisoft.common.PremiumProduct;

public abstract class Worker {
	
	private String id;
	private List<PremiumProduct> packages;
	
	public Worker(String id) {
		this.id = id;
		packages = new ArrayList<PremiumProduct>();
	}
	
	public String getId() {
		return id;
	}
	
	public void getAllPackages() {
		String message = "";
		for (PremiumProduct premiumPackage : packages) {
			message += premiumPackage.getId() + " - ";
		}
		System.out.println(message);
	}
	
	public void addPackage(PremiumProduct premiumPackage) {
		packages.add(premiumPackage);
	}
	
	abstract public void task();
	
}
