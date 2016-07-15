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
	 * ��ϵ�˲���
	 * @param contact
	 * 
	 */
	//ģ�ͷ���:������ϵ���б�
	public boolean saveContactList(List<EaseUser> contactList) {
        UserDao dao = new UserDao(context);
        dao.saveContactList(contactList);
        return true;
    }
	//ģ�ͷ���:��ȡ��ϵ���б�
	public Map<String, EaseUser> getContactList() {
        UserDao dao = new UserDao(context);
        return dao.getContactList();
    }
	//����һ����ϵ��
	public void saveContact(EaseUser user){
        UserDao dao = new UserDao(context);
        dao.saveContact(user);
    }
	
	/**
	 * �û�������
	 * @param username 
	 *
	 */
	//���õ�ǰ�û���
	public void setCurrentUserName(String username){
		MyPreferenceManager.getInstance().setCurrentUserName(username);
	}
	//��ȡ��ǰ�û���
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
