package DataStorage;
import java.util.ArrayList;

import com.qq.vip.singleangel.sight.ClassDefined.Server.Action;
import com.qq.vip.singleangel.sight.ClassDefined.Server.HeartBeatsInfo;


/**
 * �洢������������С�����ݣ�������ȫ�ֱ����У�֮���Ǽ���MySQL
 * @author singl
 *
 */
public class DataThings {
	private static ArrayList<HeartBeatsInfo> info = new ArrayList<HeartBeatsInfo>();
	private static ArrayList<Action> actions = new ArrayList<Action>();
	public static ArrayList<HeartBeatsInfo> getInfo(){
		return info;
	}
	
	/**
	 * ����Info�Ƿ���List��
	 * ����ڵĻ���������Ϣ�Ƿ���ͬ�������ͬ������
	 * @param info
	 */
	public static void addInfo(HeartBeatsInfo hbinfo) {
		boolean isIn = false;
		for(HeartBeatsInfo information: info) {
			if(information.getMacAdd().equals(hbinfo.getMacAdd())) {
				isIn = true;
				if(!information.getIpAdd().equals(hbinfo.getIpAdd())) {
					info.remove(information);
					info.add(hbinfo);
				}
			}
		}
		if(!isIn) {
			info.add(hbinfo);
		}
	}
	
	public static boolean addAction(String macAdd, String action, String conMacAdd) {
		if(conMacAdd != null ) {
			Action act = new Action(macAdd, action, conMacAdd);
			actions.add(act);
			return true;
		}else {
			Action act = new Action(macAdd, action, "");
			actions.add(act);
			return true;
		}
	}
	
}
