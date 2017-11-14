package Thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.qq.vip.singleangel.sight.ClassDefined.Server.HeartBeatsInfo;

import DataStorage.DataThings;



public class HeartBeats implements Runnable{
	private static final int  HB_PORT = 34567; //����������Ϣ�Ķ˿�
	
	public HeartBeats() {
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
					try {
						@SuppressWarnings("resource")
						ServerSocket serverSocket = new ServerSocket(HB_PORT);
						
						while(true) {
							try {
								Socket heartClient = serverSocket.accept();
								heartClient.setKeepAlive(true);
								Executor excutor = Executors.newFixedThreadPool(100);
								excutor.execute(new Runnable() {
									//����Socket, ��ͻ��˷�������
									@Override
									public void run() {
										// TODO Auto-generated method stub
										Socket client = heartClient;
											
											try {
												InetAddress inet = client.getInetAddress();
												String ip_add = inet.getHostAddress().toString();
												InputStream inStream = client.getInputStream();
												ObjectInputStream oiStream = new ObjectInputStream(inStream);
												HeartBeatsInfo info = (HeartBeatsInfo) oiStream.readObject();
												/**
												 * ����java.io.NotSerializableException: java.net.Socket
												 */
												client.shutdownInput();
												info.setIpAdd(ip_add);
												client.setKeepAlive(true);
												info.setSocket(client);  
												DataThings.addInfo(info);
											}catch(IOException e) {
												e.printStackTrace();
											} catch (ClassNotFoundException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}finally {
												//���ֳ�����
												/**
												try {
													if(client != null) {
														client.close();
													}
												}catch(IOException e) {
													e.printStackTrace();
												}**/
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
}
