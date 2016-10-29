package remote;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import vo.Package;

public class Client {

	Socket socketConnection;
	ObjectInputStream in;
	ObjectOutputStream out;

	public Client() {
		try {
			socketConnection = new Socket(InetAddress.getLocalHost(), 6689);
			in = new ObjectInputStream(socketConnection.getInputStream());
			out = new ObjectOutputStream(socketConnection.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Package getData() {
		Package data = null;

		try {

			data = (Package) in.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public void sendData(Package data) {

		try {

			out.writeObject(data);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean close() {
		try {
			in.close();
			out.flush();
			out.close();
			socketConnection.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

}