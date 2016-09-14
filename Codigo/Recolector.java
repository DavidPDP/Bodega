package logicaBodega;

import java.util.Random;

public class Recolector extends Thread{

	private Principal principal;
	private int paquetes;
	
	public Recolector(Principal principal){
		this.principal = principal;
		paquetes = 0;
	}
	
	public void run() {
		Random tiempo = new Random();
		while(true){
			principal.armarPaquete();
			paquetes++;
			System.out.println("El recolector creo el paquete numero: " + paquetes);
			try {
				Thread.sleep(tiempo.nextInt(3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	
	
}
