package com.qq.vip.singleangel.sight.ClassDefined.WiFiP2P;


import java.io.Serializable;

/**
 * Created by singl on 2017/11/14.
 */

public class Device implements Serializable {

    private final static String TAG = "Device";

    private int deviceID;           //�豸��ID��
    private String deviceName;      //�豸����
    private String macAdd;          //�豸MAC��ַ
    private String ipAdd;           //�豸IP��ַ

    /**
     * ��־λ��FLAG
     */
    private boolean isWiFiEnabled;  //Wifi�Ƿ���
    private boolean isDiscover;     //�Ƿ��ڷ���״̬���ñ�־λ��¼��һ�η��ֵĽ��������ɲο�WifiP2PService
    private boolean isConnected;    //�Ƿ����ӱ�־λ
    private boolean isGroupOwner;   //�Ƿ���GO��־λ
    private boolean isChannelDisconnected;  //�ŵ��Ͽ�

    public final static boolean CONNECTED = true;
    public final static boolean NOT_CONNECTED = false;
    public final static boolean IS_GROUPOWNER = true;
    public final static boolean NOT_GROUPOWNER = false;
    public final static boolean WIFI_ENABLED = true;
    public final static boolean WIFI_DISABLED = false;
    public final static boolean DISCOVERED = true;
    public final static boolean NOT_DISCOVERED = false;
    public final static boolean CHANNEL_CONNECTED = true;
    public final static boolean CHANNEL_DISCONNECTED = false;
    public final static String NULL_STRING = "";

    /**
     * ���캯����Ĭ��ֻ��mac��ַ������Device��֮�������SET����������ֵ����
     * @param macAdd
     */
    public Device(String macAdd){
        if (checkHash(HashWithMAC(macAdd))){
            this.deviceID = HashWithMAC(macAdd);
        }
        this.deviceName = NULL_STRING;
        this.macAdd = macAdd;
        this.ipAdd = NULL_STRING;
        this.isConnected = NOT_CONNECTED;
        this.isGroupOwner = NOT_GROUPOWNER;
        this.isWiFiEnabled = WIFI_DISABLED;
        this.isDiscover = NOT_DISCOVERED;
        this.isChannelDisconnected = CHANNEL_DISCONNECTED;
    }

    /**
     * ���캯����ȱ��IP��ַ��Ϣ�Ĺ��캯��
     * @param deviceID
     * @param isConnected
     * @param isGroupOwner
     * @param deviceName
     * @param macAdd
     */
    public Device(int deviceID, boolean isConnected, boolean isGroupOwner,
                  boolean isWiFiEnabled, boolean isDiscover, boolean isChannelDisconnected,
                  String deviceName, String macAdd){
        if (checkHash(HashWithMAC(macAdd))){
            this.deviceID = HashWithMAC(macAdd);
        }
        this.isConnected = isConnected;
        this.isGroupOwner = isGroupOwner;
        this.deviceName = deviceName;
        this.macAdd = macAdd;
        this.ipAdd = NULL_STRING;
        this.isWiFiEnabled = isWiFiEnabled;
        this.isDiscover = isDiscover;
        this.isChannelDisconnected = isChannelDisconnected;
    }

    /**
     * ���캯����ӵ��ȫ�������Ĺ��캯��
     * @param deviceID
     * @param isConnected
     * @param isGroupOwner
     * @param deviceName
     * @param macAdd
     * @param ipAdd
     */
    public Device(int deviceID, boolean isConnected, boolean isGroupOwner,
                  boolean isWiFiEnabled, boolean isDiscover, boolean isChannelDisconnected,
                  String deviceName, String macAdd, String ipAdd){
        if (checkHash(HashWithMAC(macAdd))){
            this.deviceID = HashWithMAC(macAdd);
        }
        this.isConnected = isConnected;
        this.isGroupOwner = isGroupOwner;
        this.deviceName = deviceName;
        this.macAdd = macAdd;
        this.ipAdd = ipAdd;
        this.isWiFiEnabled = isWiFiEnabled;
        this.isDiscover = isDiscover;
        this.isChannelDisconnected = isChannelDisconnected;
    }

    /**
     * ʹ�ù�ϣ������MAC��ַ���ɹ̶�λ����INT����
     * �����MAC��ַ�����ʽxx:xx:xx:xx:xx:xx������x=0-9,A-F
     * @param macAdd
     * @return
     */
    public static int HashWithMAC(String macAdd){
        String removeString = macAdd.replace(":","");
        /**
         * ��ʽ���
         */
        int i = 0;
        for (; i < removeString.length(); i++){
            char c = removeString.charAt(i);
            if ('A'<= c){
                if (c <= 'F'){ //c��A��F֮��
                    //do noting
                }else {
                    return 0;
                }
            }else if (c <= '9'){
                if ('0' <= c){  //c��0��9֮��
                    //do noting
                }else {   //�������
                    return 0;
                }
            }
        }
        if (i == (removeString.length() - 1) && i == 11){
            //do noting
        }else {
            return 0;  //λ������
        }
        int hash = removeString.hashCode();
        return hash;
    }

    public boolean checkHash(int zero){
        if (0 == zero){   //���ɵ�hash����
      //      MyLog.debug(TAG, "Hash is going wrong.");
            return false;
        }else {
            return true;
        }
    }

    /**
     * ���ò�������
     * @param macAdd
     */
    public void setDeviceID(String macAdd){
        if (checkHash(HashWithMAC(macAdd))){
            this.deviceID = HashWithMAC(macAdd);
        }
    }
    public void setConnected(boolean isConnected){
        this.isConnected = isConnected;
    }
    public void setGroupOwner(boolean isGroupOwner){
        this.isGroupOwner = isGroupOwner;
    }
    public void setDeviceName(String deviceName){
        this.deviceName = deviceName;
    }
    public void setMacAdd(String macAdd){
        this.macAdd = macAdd;
    }
    public void setIpAdd(String ipAdd){
        this.ipAdd = ipAdd;
    }
    public void setWifiEnabled(boolean isWiFiEnabled){
        this.isWiFiEnabled = isWiFiEnabled;
    }
    public void setDiscover(boolean isDiscover){
        this.isDiscover = isDiscover;
    }
    public void setChannelDisconnected(boolean isChannelDisconnected){
        this.isChannelDisconnected = isChannelDisconnected;
    }
    /**
     * �õ���������
     * @return
     */
    public int getDeviceID(){
        return this.deviceID;
    }
    public boolean isConnected(){
        return this.isConnected;
    }
    public boolean isGroupOwner(){
        return this.isGroupOwner;
    }
    public String getDeviceName(){
        return this.deviceName;
    }
    public String getMacAdd(){
        return this.macAdd;
    }
    public String getIpAdd(){
        return this.ipAdd;
    }
    public boolean isWiFiEnabled(){
        return this.isWiFiEnabled;
    }
    public boolean isDiscover(){
        return this.isDiscover;
    }
    public boolean isChannelDisconnected(){
        return this.isChannelDisconnected;
    }

    /**
     * ʹ��Device�������½�һ���µ�Device����
     * @param device
     * @return
     */
    public boolean updateDevice(Device device){
        setDeviceID(device.getMacAdd());
        setConnected(device.isConnected());
        setGroupOwner(device.isGroupOwner());
        setDeviceName(device.getDeviceName());
        setMacAdd(device.getMacAdd());
        setIpAdd(device.getIpAdd());
        setWifiEnabled(device.isWiFiEnabled());
        setDiscover(device.isDiscover());
        setChannelDisconnected(device.isChannelDisconnected());
        return true;
    }


}
