package com.yanghao.chatdemo.dao;

import java.util.List;
import java.util.Map;

import com.hyphenate.easeui.domain.EaseUser;
import com.yanghao.chatdemo.db.DBManager;

import android.content.Context;

public class UserDao {
	public static final String TABLE_NAME = "uers";
	public static final String COLUMN_NAME_ID = "username";
	public static final String COLUMN_NAME_NICK = "nick";
	public static final String COLUMN_NAME_AVATAR = "avatar";
	
	public static final String PREF_TABLE_NAME = "pref";
	public static final String COLUMN_NAME_DISABLED_GROUPS = "disabled_groups";
	public static final String COLUMN_NAME_DISABLED_IDS = "disabled_ids";

	public static final String ROBOT_TABLE_NAME = "robots";
	public static final String ROBOT_COLUMN_NAME_ID = "username";
	public static final String ROBOT_COLUMN_NAME_NICK = "nick";
	public static final String ROBOT_COLUMN_NAME_AVATAR = "avatar";
	
	
	public UserDao(Context context) {
	}
	
	//保存联系人列表
	public void saveContactList(List<EaseUser> contactList){
		DBManager.getInstance().saveContactList(contactList);
	}
	//获取联系人
	public Map<String,EaseUser> getContactList(){
		return DBManager.getInstance().getContactList();
	}
	//删除联系人
	public void deleteContact(String username){
		DBManager.getInstance().deleteContact(username);
	}
	//保存联系人
	public void saveContact(EaseUser user) {
		DBManager.getInstance().saveContact(user);
	}
	

}
