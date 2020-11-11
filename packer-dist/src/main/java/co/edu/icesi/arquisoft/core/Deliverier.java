package co.edu.icesi.arquisoft.core;

public abstract class Deliverier {
	
	private String id;

	public Deliverier(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	abstract public void deliver();
	
}
