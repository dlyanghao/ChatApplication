package com.yanghao.chatdemo.application;

import android.app.Application;
import android.content.Context;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.yanghao.chatdemo.model.ChatDemoModel;

public class DemoHelper extends Application {
	//设定TAG标注
	private static final String TAG = DemoHelper.class.getSimpleName();
	//定义静态变量DemoHelper
	private static DemoHelper instance = null;
	private String username;
	private ChatDemoModel doModel;
	public static Context applicationContext;
	//构造方法
	public DemoHelper() {
		
	}
	
	@Override
	public void onCreate() {
		applicationContext = this.getApplicationContext();
		instance = this;
		doModel = new ChatDemoModel(applicationContext);
		init();
	}
	
	//application的初始化(初始化DemoHelper)
	public void init(){
		EMOptions options = new EMOptions();
		//添加好友：设置成需要验证才能添加好友
		options.setAcceptInvitationAlways(false);
		//初始化
		EMClient.getInstance().init(this, options);
		//在做打包混淆时，关闭debug模式，避免消耗不必要的资源
		EMClient.getInstance().setDebugMode(true);
	}
	
	//方法:获取DemoHelper实例，加入synchronized同步
	public synchronized static DemoHelper getInstance(){
		if(null == instance){
			instance = new DemoHelper();
		}
		return instance;
	}
	
	/**
	 * 用户名操作
	 * @UsernName
	 */
	
	
	//获取当前用户名
	public String getCurrentUserName(){
    	if(username == null){
    		username = doModel.getCurrentUserName();
    	}
    	return username;
    }
	//设置当前用户名
	public void setCurrentUserName(String username){
			this.username = username;
			doModel.setCurrentUserName(username);
	}
	
}
