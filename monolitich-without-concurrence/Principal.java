package logicaBodega;


public class Principal {

	private Bodega bodega;
	private Recolector recolector;
	private Depositador depositador;
	
	public Principal(){
		bodega = new Bodega(0, 0);
		recolector = new Recolector(this);
		depositador = new Depositador(this);
	}
	
	public void proceso(){
		recolector.start();
		depositador.start();
	}
	
	public void depositarArticulo(double articulo){
		try {
			bodega.colocarArticulo(articulo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void armarPaquete(){
		bodega.armarPaquete();
	}
	
	public static void main(String[] args){
		new Principal().proceso();
	}
	
}
