package logicaBodega;

import java.util.Random;

public class Depositador extends Thread{

	private Principal principal;
	
	public Depositador(Principal principal){
		this.principal = principal;
	}
	
	
	public void run() {
		Random randomTipo = new Random();
		Random tiempo = new Random();
		while(true){
			int tipo = randomTipo.nextInt(2)+1;
			principal.depositarArticulo(tipo);
			System.out.println("El depositador acabó de colocar un paquete tipo: " + tipo);
			try {
				Thread.sleep(tiempo.nextInt(3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	
	
	
	
}
