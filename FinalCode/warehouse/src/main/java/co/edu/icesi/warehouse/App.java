package co.edu.icesi.warehouse;

import java.util.UUID;

public class App 
{
    public static void main( String[] args ) {
    	Warehouse warehouse = new Warehouse();
        
    	Deliverier firtsDeliverier = 
        		new FedexDeliverier(UUID.randomUUID().toString(), warehouse);
        Deliverier secondDeliverier =
        		new ServientregraDeliverier(
        				UUID.randomUUID().toString(), warehouse);
        
        Worker firstWorker = new PremiumSender(
        		UUID.randomUUID().toString(), warehouse);
        Worker secondWorker = new Packer(
        		UUID.randomUUID().toString(), warehouse);
        
        Thread deliverier1Task1 = new Thread(firtsDeliverier);
        Thread deliverier2Task1 = new Thread(secondDeliverier);
        
        Thread worker1Task1 = new Thread(firstWorker);
        Thread worker2Task1 = new Thread(secondWorker);
        
        deliverier1Task1.start();
        deliverier2Task1.start();
        worker1Task1.start();
        worker2Task1.start();
        
        try {
			deliverier1Task1.join();
			deliverier2Task1.join();
			worker1Task1.join();
			worker2Task1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
