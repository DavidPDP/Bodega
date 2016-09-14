package logicaBodega;

public class Bodega {
	
	private volatile double articuloUno; // articulo de tipo uno, volumen 10m^3 
	private volatile double articuloDos; // articulo de tipo uno, volumen 15m^3
	public final static double CAPACIDAD_MAXIMA = 200; //capacidad maxima de la bodega, volumen 200m^3
	
	public Bodega(double articuloUno, double articuloDos){
		this.articuloUno = articuloUno;
		this.articuloDos = articuloDos;
	}
	
	public void colocarArticulo(double articulo) throws Exception{
		if(articulo == 1){
			while(articuloUno + articuloDos > 19){
				
			}
			articuloUno++;
		}
		else if(articulo == 2){
			while(articuloUno + articuloDos > 12.333){
				
			}
			articuloDos++;
		}
		else{
			throw new Exception("No existe un articulo de ese tipo");
		}
		System.out.println("Capacidad actual de bodega: " + (int)darCapacidadActual());
		System.out.println("Articulos Tipo Uno: " + (int)articuloUno);
		System.out.println("Articulos Tipo Dos: " + (int)articuloDos);
	}
	
	public void armarPaquete(){
		while(articuloUno < 3 || articuloDos < 4){
			
		}
		articuloUno -= 3;
		articuloDos -= 4;
	}
	
	public double darCapacidadActual(){
		return (articuloUno*10) + (articuloDos*15);
	}
}
