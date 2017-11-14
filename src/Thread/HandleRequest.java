package Thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.qq.vip.singleangel.sight.ClassDefined.Server.Action;
import com.qq.vip.singleangel.sight.ClassDefined.Server.HeartBeatsInfo;
import com.qq.vip.singleangel.sight.ClassDefined.Server.Request;

import DataStorage.DataThings;

public class HandleRequest implements Runnable{
	private static int HAND_REQUEST_PORT = 22333;
	@Override
	public void run() {
		// TODO Auto-generated method stub
				try {
					ServerSocket serverSocket = new ServerSocket(HAND_REQUEST_PORT);
					while(true) {
						try {
							Socket requestClient = serverSocket.accept();
							
							Executor excutor = Executors.newFixedThreadPool(100);
							excutor.execute(new Runnable() {
								//����Socket, ��ͻ��˷�������
								@Override
								public void run() {
									// TODO Auto-generated method stub
									Socket client = requestClient;
									try {
										InputStream inStream = client.getInputStream();
										ObjectInputStream oiStream = new ObjectInputStream(inStream);
										try {
											Request request = (Request) oiStream.readObject();
											String ip = client.getInetAddress().getHostAddress().toString();
											Action action = new Action(ip, Action.START_DISCOVER, null); 
											ObjectOutputStream otStream = new ObjectOutputStream(client.getOutputStream());
											otStream.writeObject(action);
											handleWithRequest(request);
										} catch (ClassNotFoundException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}catch(IOException e) {
										e.printStackTrace();
									}finally {
								
									}
									
								}
								
							});
						}catch(IOException e) {
							e.printStackTrace();
						}
					}
				}catch(IOException e) {
					e.printStackTrace();
				}
	}
	
	public boolean handleWithRequest(Request request) {
		boolean success = false;
		switch(request.getRequestType()) {
			case Request.INITIATIVE:
				ArrayList<HeartBeatsInfo> infoList = DataThings.getInfo();
				for(HeartBeatsInfo info : infoList) {
					String ip = info.getIpAdd();
					Socket socket = info.getSocket();
					Action action = new Action(ip, Action.START_CONNECT, null); 
					//if (socket.isConnected()) {
						SendAction sendAction = new SendAction(socket, ip,action);
						Thread thread = new Thread(sendAction);
						thread.start();
					}
				break;
			case Request.ON_DEMAND:
				break;
		}
		return success;
	}

}