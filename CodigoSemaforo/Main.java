package logica;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		Bodega bodega = new Bodega();
		Depositador depositador = new Depositador(bodega);
		Recolector recolector = new Recolector(bodega);
	}
}
