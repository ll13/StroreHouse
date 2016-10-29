package remote;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import vo.Package;

public class Server {
	ServerSocket socketConnection;
	Socket socket;
	ObjectOutputStream out;
	ObjectInputStream in;
	public Server() {
		try {

			socketConnection = new ServerSocket(6689);
			System.out.println("�������Ѿ��������ȴ����ӡ�");
			socket = socketConnection.accept();
			System.out.println("�����ӡ�");
		    out = new ObjectOutputStream(socket.getOutputStream());
		    in = new ObjectInputStream(socket.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendData(Package data) {
		try {
			

			out.writeObject(data);
			System.out.println("�ѷ�����");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Package getData() {
		Package newdata = null;
		try {
			
			while (newdata == null) {
				newdata = (Package) in.readObject();
			}
			System.out.print("���յ�");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newdata;
	}
	
	public boolean close(){
		try{  out.flush();
		      out.close();
		      in.close();
			socketConnection.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
