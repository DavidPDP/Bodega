package packRikolino;

import java.util.Random;

public class Depositador {

	public Depositador(final Bodega bodega)
	{
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Random r = new Random(1);
				try {
					while(true)
					{
						bodega.depositar(r.nextInt(2));
						Thread.sleep(200);
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
