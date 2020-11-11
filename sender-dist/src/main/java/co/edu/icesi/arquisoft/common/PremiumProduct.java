package co.edu.icesi.arquisoft.common;

public class PremiumProduct {
	
	public static final double PRODUCT_PRICE = 400000;
	public static final String PACKAGE_1 = "FEDEX_PACKAGE";
	public static final String PACKAGE_2 = "SERVIENTREGA_PACKAGE";
	public static final int PACKAGE_1_AMOUNT = 4;
	public static final int PACKAGE_2_AMOUNT = 3;
	
	private String id;
	private String from;
	private String to;
	
	private int volume;
	
	public PremiumProduct(String id, String from, String to) {
		this.id = id;
		this.volume = volume();
	}
	
	private int volume() {
		return RawPackageType.valueOf(PACKAGE_1).volume() * PACKAGE_1_AMOUNT +
				RawPackageType.valueOf(PACKAGE_2).volume() * PACKAGE_2_AMOUNT;
	}
	
	public String getId() {
		return id;
	}
	
	public String getFrom() {
		return from;
	}
	
	public String getTo() {
		return to;
	}
	
	public int getVolume() {
		return volume;
	}
	
}