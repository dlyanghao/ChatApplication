package com.yanghao.chatdemo.application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;

import android.app.Application;

public class DemoHelper extends Application {
	//�趨TAG��ע
	protected static final String TAG = DemoHelper.class.getSimpleName();
	//���徲̬����DemoHelper
	private static DemoHelper instance = null;
	//���췽��
	public DemoHelper() {

	}
	//application�ĳ�ʼ��(��ʼ��DemoHelper)
	public void init(){
		EMOptions options = new EMOptions();
		//��Ӻ��ѣ����ó���Ҫ��֤������Ӻ���
		options.setAcceptInvitationAlways(false);
		//��ʼ��
		EMClient.getInstance().init(getApplicationContext(), options);
		//�����������ʱ���ر�debugģʽ���������Ĳ���Ҫ����Դ
		EMClient.getInstance().setDebugMode(true);
	}
	
	//����:��ȡDemoHelperʵ��������synchronizedͬ��
	public synchronized DemoHelper getInstance(){
		if(null == instance){
			instance = new DemoHelper();
		}
		return instance;
	}
	


	

}
