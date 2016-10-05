package logica;

import java.util.Random;

public class Recolector {
	
	public Recolector(final Bodega bodega)
	{
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					while(true)
					{
						bodega.descargar();
						Thread.sleep(3000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t.start();
	}
}
