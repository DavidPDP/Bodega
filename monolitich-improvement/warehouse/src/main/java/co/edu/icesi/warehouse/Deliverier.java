package co.edu.icesi.warehouse;

public abstract class Deliverier implements Runnable{
	
	private String id;

	public Deliverier(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	abstract public void deliver();
}
