package co.edu.icesi.warehouse;

public enum RawPackageType {
	FEDEX_PACKAGE("FEDEX", 10, 0.58),
	SERVIENTREGA_PACKAGE("SERVIENTREGA", 15, 0.42);
	
	private int fedex;
	private int servientrega;
	
	private String type;
	private int volume;
	private double distribution;
	
	private RawPackageType(String type, int volume, double distribution) {
		this.type = type;
		this.volume = volume;
		this.distribution = distribution;
	}
		
	public String type() {
		return type;
	}
	
	public int volume() {
		return volume;
	}
	
	public double distribution() {
		return distribution;
	}
	
	public int amount() {
		if(this.type.equals(FEDEX_PACKAGE.type)) {
			return fedex;
		}else {
			return servientrega;
		}
	}
	
	public void increment() {
		if(this.type.equals(FEDEX_PACKAGE.type)) {
			fedex++;
		}else {
			servientrega++;
		}
	}
	
	public void decrement(int amount) {
		if(this.type.equals(FEDEX_PACKAGE.type)) {
			fedex-=amount;
		}else {
			servientrega-=amount;
		}
	}
	
}
