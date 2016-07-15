package com.yanghao.chatdemo.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;

import com.hyphenate.easeui.domain.EaseUser;
import com.yanghao.chatdemo.dao.UserDao;
import com.yanghao.chatdemo.utils.MyPreferenceManager;

public class ChatDemoModel {
	UserDao user = null;
	protected Context context = null;
	protected Map<Key,Object> valueCache = new HashMap<Key,Object>();
	
	public ChatDemoModel(Context ctx){
		context = ctx;
		MyPreferenceManager.init(context);
	}
	
	/**
	 * 联系人操作
	 * @param contact
	 * 
	 */
	//模型方法:保存联系人列表
	public boolean saveContactList(List<EaseUser> contactList) {
        UserDao dao = new UserDao(context);
        dao.saveContactList(contactList);
        return true;
    }
	//模型方法:获取联系人列表
	public Map<String, EaseUser> getContactList() {
        UserDao dao = new UserDao(context);
        return dao.getContactList();
    }
	//保存一个联系人
	public void saveContact(EaseUser user){
        UserDao dao = new UserDao(context);
        dao.saveContact(user);
    }
	
	/**
	 * 用户名操作
	 * @param username 
	 *
	 */
	//设置当前用户名
	public void setCurrentUserName(String username){
		MyPreferenceManager.getInstance().setCurrentUserName(username);
	}
	//获取当前用户名
	public String getCurrentUserName(){
		return "";//PreferenceManager.getInstance().getCurrentUsername();
	}
	
	enum Key{
        VibrateAndPlayToneOn,
        VibrateOn,
        PlayToneOn,
        SpakerOn,
        DisabledGroups,
        DisabledIds
    }
	

}
