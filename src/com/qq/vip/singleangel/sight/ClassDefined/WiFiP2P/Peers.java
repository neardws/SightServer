package com.qq.vip.singleangel.sight.ClassDefined.WiFiP2P;

import java.io.Serializable;

/**
 * Created by singl on 2017/11/14.
 */

public class Peers implements Serializable {
    private int deviceID;    //�ھ��豸ID
    private int rssi;        //Wifi P2P���ź�ǿ��
    private float distance;  //�ڵ�����Ծ���
    private int trend;       //�ڵ����˶�����

    public Peers(int deviceID){
        this.deviceID = deviceID;
        this.rssi = 0;
        this.distance = 0;
        this.trend = 0;
    }

    public Peers(int deviceID, int rssi, float distance, int trend ){
        this.deviceID = deviceID;
        this.rssi = rssi;
        this.distance = distance;
        this.trend = trend;
    }

    public void setDeviceID(int deviceID){
        this.deviceID = deviceID;
    }
    public void setRSSI(int rssi){
        this.rssi = rssi;
    }
    public void setDistance(int distance){
        this.distance = distance;
    }
    public void setTrend(int trend){
        this.trend = trend;
    }

    public int getDeviceID(){
        return this.deviceID;
    }
    public int getRSSI(){
        return this.rssi;
    }
    public float getDistance(){
        return this.distance;
    }
    public int getTrend(){
        return this.trend;
    }

}
