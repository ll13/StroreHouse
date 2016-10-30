package remote;
import vo.Package;
public class TestServer {
	
	
	public static void main(String args[]) {
		Server server=new  Server();
		Package p=new Package();
		p.setOperation("test");
		server.sendData(p);
		System.out.println(server.getData().getOperation());
		server.close();
	}
	
	
}
