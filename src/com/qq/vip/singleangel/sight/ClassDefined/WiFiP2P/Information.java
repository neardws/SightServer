package com.qq.vip.singleangel.sight.ClassDefined.WiFiP2P;

import java.io.Serializable;

/**
 * Created by singl on 2017/11/14.
 */


public class Information implements Serializable {
    private static final String TAG = "Information";

    private int deviceID;           //�豸ID
    private float speed;            //�豸���ٶ�
    private float acceleration;     //�ڵ�ļ��ٶ�
    private float direction;        //�ڵ�ķ�����Ϣ
    private double gpsLongitude;    //�ڵ�ľ���
    private double gpsLatiude;      //�ڵ��γ��

    /**
     * Ĭ�Ϲ��캯������Ҫ�ڵ��ID��Ϣ����Device�е�deviceIDȷ��
     * @param deviceID
     */
    public Information(int deviceID){
        this.deviceID = deviceID;
        this.speed = 0;
        this.acceleration = 0;
        this.direction = 0;
        this.gpsLongitude = 0;
        this.gpsLatiude = 0;
    }

    /**
     * ���캯����ӵ�����в���
     * @param deviceID
     * @param speed
     * @param acceleration
     * @param direction
     * @param gpsLongitude
     * @param gpsLatiude
     */
    public Information(int deviceID, float speed, float acceleration,
                       float direction, double gpsLongitude, double gpsLatiude){
        this.deviceID = deviceID;
        this.speed = speed;
        this.acceleration = acceleration;
        this.direction = direction;
        this.gpsLongitude = gpsLongitude;
        this.gpsLatiude = gpsLatiude;
    }

    /**
     * ���ò���������ֵ��ע�����deviceID��������Ĳ���ֻ���ڹ��캯���и�ֵ
     * @param speed
     */
    public void setSpeed(float speed){
        if (checkBigThanZero(speed)){
            this.speed = speed;
        }
    }
    public void setAcceleration(float acceleration){
        if (checkBigThanZero(acceleration)){
            this.acceleration = acceleration;
        }
    }
    public void setDirection(float direction){
        if (checkDirection(direction)){
            this.direction = direction;
        }
    }
    public void setGpsLongitude(double gpsLongitude){
        this.gpsLongitude = gpsLongitude;
    }
    public void setGpsLatiude(double gpsLatiude){
        this.gpsLatiude = gpsLatiude;
    }

    /**
     * ���ز�������
     * @return
     */
    public int getDeviceID(){
        return this.deviceID;
    }
    public float getSpeed(){
        return this.speed;
    }
    public float getAcceleration(){
        return this.acceleration;
    }
    public float getDirection(){
        return this.direction;
    }
    public double getGpsLongitude(){
        return this.gpsLongitude;
    }
    public double getGpsLatiude(){
        return this.gpsLatiude;
    }

    /**
     * ��ʽ��麯��
     * @return
     */
    public boolean checkID(int deviceID){
        //����deviceID�Ƿ���Ĵ��ڣ����Ƿ��Device�з���
        return true;
    }
    public boolean checkBigThanZero(float num){
        if (num >= 0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * ���ڵ������������ƫת�Ƕȣ���ֵӦ����0~360֮��
     * @param direction
     * @return
     */
    public boolean checkDirection(float direction){
        if (0 <= direction && direction <= 360){
            return true;
        }else {
            return false;
        }
    }
}
