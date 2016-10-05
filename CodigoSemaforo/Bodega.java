package logica;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Bodega {
	
	public static final int CANTIDAD_ESPACIOS_MAX = 200;
	public static final int ESPACIO_PAQUETE = 90;
	public static final int CANTIDAD_MINIMA_A = 3;
	public static final int CANTIDAD_MINIMA_B = 4;

	private Object lock;
	
	private int espacioEnBodega;
	
	private int cantidadTotalA;
	private int cantidadSinEmpacarA;

	private int cantidadTotalB;
	private int cantidadSinEmpacarB;
	
	
	private Semaphore espacioBodega;
	private Semaphore cantidadPaquetes;
	public Bodega()
	{
		this.lock = new Object();
		this.cantidadTotalA = 0;
		this.cantidadTotalB = 0;
		this.espacioEnBodega = Bodega.CANTIDAD_ESPACIOS_MAX;
		this.espacioBodega = new Semaphore(Bodega.CANTIDAD_ESPACIOS_MAX);
		this.cantidadPaquetes = new Semaphore(0);
	}
	
	public void depositar(int tipoProducto) throws InterruptedException
	{
		int peso = (tipoProducto == 1)?10:15;
		espacioBodega.acquire(peso);
		synchronized (lock) 
		{
			if(tipoProducto == 1)
			{
				cantidadTotalA++;
				cantidadSinEmpacarA++;
			}
			else
			{
				cantidadTotalB++;
				cantidadSinEmpacarB++;
			}
			espacioEnBodega -= peso;
			System.out.println("Agrego producto: " + "A: " + cantidadTotalA + " -- B: " + cantidadTotalB + " -- Espacio Bodega: " + espacioEnBodega);
		}
		if(cantidadSinEmpacarA >= Bodega.CANTIDAD_MINIMA_A && cantidadSinEmpacarB >= Bodega.CANTIDAD_MINIMA_B)
		{
			cantidadSinEmpacarA -= Bodega.CANTIDAD_MINIMA_A;
			cantidadSinEmpacarB -= Bodega.CANTIDAD_MINIMA_B;
			//Empacar
			cantidadPaquetes.release();
			System.out.println("Agrego Paquete:" + cantidadPaquetes.availablePermits());
		}
	}
	
	public void descargar() throws InterruptedException
	{
		cantidadPaquetes.acquire();
		synchronized (lock) {
			cantidadTotalA -= Bodega.CANTIDAD_MINIMA_A;
			cantidadTotalB -= Bodega.CANTIDAD_MINIMA_B;
			espacioEnBodega += Bodega.ESPACIO_PAQUETE;
		}
		System.out.println("Consumio paquete. CantidadPaquetes: " + cantidadPaquetes.availablePermits());
		espacioBodega.release(Bodega.ESPACIO_PAQUETE);
	}
}
