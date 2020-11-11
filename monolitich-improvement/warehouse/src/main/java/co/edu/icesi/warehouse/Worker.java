package co.edu.icesi.warehouse;

import java.util.ArrayList;
import java.util.List;

public abstract class Worker implements Runnable{
	
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
