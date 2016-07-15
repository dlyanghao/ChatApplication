package com.yanghao.chatdemo.application;

import android.app.Application;
import android.content.Context;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.yanghao.chatdemo.model.ChatDemoModel;

public class DemoHelper extends Application {
	//�趨TAG��ע
	private static final String TAG = DemoHelper.class.getSimpleName();
	//���徲̬����DemoHelper
	private static DemoHelper instance = null;
	private String username;
	private ChatDemoModel doModel;
	public static Context applicationContext;
	//���췽��
	public DemoHelper() {
		
	}
	
	@Override
	public void onCreate() {
		applicationContext = this.getApplicationContext();
		instance = this;
		doModel = new ChatDemoModel(applicationContext);
		init();
	}
	
	//application�ĳ�ʼ��(��ʼ��DemoHelper)
	public void init(){
		EMOptions options = new EMOptions();
		//��Ӻ��ѣ����ó���Ҫ��֤������Ӻ���
		options.setAcceptInvitationAlways(false);
		//��ʼ��
		EMClient.getInstance().init(this, options);
		//�����������ʱ���ر�debugģʽ���������Ĳ���Ҫ����Դ
		EMClient.getInstance().setDebugMode(true);
	}
	
	//����:��ȡDemoHelperʵ��������synchronizedͬ��
	public synchronized static DemoHelper getInstance(){
		if(null == instance){
			instance = new DemoHelper();
		}
		return instance;
	}
	
	/**
	 * �û�������
	 * @UsernName
	 */
	
	
	//��ȡ��ǰ�û���
	public String getCurrentUserName(){
    	if(username == null){
    		username = doModel.getCurrentUserName();
    	}
    	return username;
    }
	//���õ�ǰ�û���
	public void setCurrentUserName(String username){
			this.username = username;
			doModel.setCurrentUserName(username);
	}
	
}
