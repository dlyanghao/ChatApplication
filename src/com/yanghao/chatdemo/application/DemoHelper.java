package com.yanghao.chatdemo.application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;

import android.app.Application;

public class DemoHelper extends Application {
	//设定TAG标注
	protected static final String TAG = DemoHelper.class.getSimpleName();
	//定义静态变量DemoHelper
	private static DemoHelper instance = null;
	//构造方法
	public DemoHelper() {

	}
	//application的初始化(初始化DemoHelper)
	public void init(){
		EMOptions options = new EMOptions();
		//添加好友：设置成需要验证才能添加好友
		options.setAcceptInvitationAlways(false);
		//初始化
		EMClient.getInstance().init(getApplicationContext(), options);
		//在做打包混淆时，关闭debug模式，避免消耗不必要的资源
		EMClient.getInstance().setDebugMode(true);
	}
	
	//方法:获取DemoHelper实例，加入synchronized同步
	public synchronized DemoHelper getInstance(){
		if(null == instance){
			instance = new DemoHelper();
		}
		return instance;
	}
	


	

}
