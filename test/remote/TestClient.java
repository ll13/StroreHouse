package remote;

import vo.Package;

public class TestClient {
	public static void main(String args[]) {
		Client client=new Client();
		Package p=new Package();
		
		p=client.getData();
		System.out.println(p.getOperation());
		client.sendData(p);
		client.close();
	}
}
