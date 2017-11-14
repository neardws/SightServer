package com.qq.vip.singleangel.sight.ClassDefined.Server;

/**
 * Created by singl on 2017/11/14.
 */

import java.io.Serializable;

public class Action implements Serializable {
    private String macAdd;   		//������յĿͻ��˵�Mac��ַ
    private String action;			//����
    private String connectMacAdd;	//��������������������Ŀͻ���Ҫ���ӵĿͻ��˵�Mac��ַ

    //��������ͻ��˷��͵�����
    public static final String START_DISCOVER = "StartDiscover";
    public static final String STOP_DISCOVER = "StopDiscover";
    public static final String START_CONNECT = "StartConnect";
    public static final String STOP_CONNECT = "StopConnect";

    public Action(String macAdd, String action, String connectMacAdd) {
        this.macAdd = macAdd;
        this.action = action;
        this.connectMacAdd = connectMacAdd;
    }

    public String getMacAdd() {
        return this.macAdd;
    }
    public String getAction() {
        return this.action;
    }
    public String getConnectMacAdd() {
        return this.connectMacAdd;
    }
    public void setMacAdd(String macAdd) {
        this.macAdd = macAdd;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public void setConnectMacAdd(String connectMacAdd) {
        this.connectMacAdd = connectMacAdd;
    }

}