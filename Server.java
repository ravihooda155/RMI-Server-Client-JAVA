import java.rmi.*;
import java.rmi.registry.LocateRegistry;
public class Server {
	public static void main(String args[]) throws Exception{
		try {
			LocateRegistry.createRegistry(6600);
			ServiceAdder addService=new ServiceAdder();
			Naming.rebind("rmi://0.0.0.0:6600/Add",addService);
			System.out.println("Server Started ................");	

		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
