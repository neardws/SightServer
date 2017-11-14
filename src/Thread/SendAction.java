package Thread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.qq.vip.singleangel.sight.ClassDefined.Server.Action;


public class SendAction implements Runnable{
	private Action action;
	private String ipAdd;
	private Socket socket;
	
	public SendAction(Socket socket, String ipadd,Action action) {
		this.socket = socket;
		this.ipAdd = ipadd;
		this.action = action;
	}

	@SuppressWarnings("null")
	@Override
	public void run() {
		//Socket socket = null;
		 try {
	      //     socket.bind(null);
	           /**
	            * * ����ʱ��ҪIP address. port . 5000������ʱ�䣬Ӧ����5S
	            */
	         //   socket.connect(new InetSocketAddress(ipAdd,22233),5000);
	            try {
        			ObjectOutputStream objOutputStream = new ObjectOutputStream(socket.getOutputStream());
        			objOutputStream.writeObject(action);
        			objOutputStream.flush();
        			/*
        			 * ����socket.getOutputStream()
        			 */
        			//outputStream.close();  
        		}catch(IOException e) {
        			e.printStackTrace();
        		}
		 }finally {
			 /**try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}**/
		 } 
		 // TODO Auto-generated method stub
		
	}
}
