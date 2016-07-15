package com.yanghao.chatdemo.db;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hyphenate.easeui.domain.EaseUser;
import com.yanghao.chatdemo.application.DemoHelper;
import com.yanghao.chatdemo.dao.UserDao;

public class DBManager {
	static private DBManager dbMgr = new DBManager();
	private DBOpenHelper dbHelper;
	
	//���췽��
	public DBManager() {
		dbHelper = DBOpenHelper.getInstance(DemoHelper.getInstance().getApplicationContext());
	}
	//����:��ȡʵ��
	public static synchronized DBManager getInstance(){
        if(dbMgr == null){
            dbMgr = new DBManager();
        }
        return dbMgr;
    }
	
	//������ϵ���б��������ݿ�
	synchronized public void saveContactList(List<EaseUser> contactList)
	{
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		if(db.isOpen()){
			db.delete(UserDao.TABLE_NAME, null, null);
			for (EaseUser user : contactList) {
                ContentValues values = new ContentValues();
                values.put(UserDao.COLUMN_NAME_ID, user.getUsername());
                if(user.getNick() != null)
                    values.put(UserDao.COLUMN_NAME_NICK, user.getNick());
                if(user.getAvatar() != null)
                    values.put(UserDao.COLUMN_NAME_AVATAR, user.getAvatar());
                db.replace(UserDao.TABLE_NAME, null, values);
            }
		}
	}
	
	//�����ݿ��л�ȡ��ϵ���б�
	synchronized public Map<String,EaseUser> getContactList(){
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Map<String, EaseUser> users = new Hashtable<String, EaseUser>();
		if(db.isOpen()){
			Cursor cursor = db.rawQuery("select * from " + UserDao.TABLE_NAME,null);
			while(cursor.moveToNext()){
				String username = cursor.getString(cursor.getColumnIndex(UserDao.COLUMN_NAME_ID));
                String nick = cursor.getString(cursor.getColumnIndex(UserDao.COLUMN_NAME_NICK));
                String avatar = cursor.getString(cursor.getColumnIndex(UserDao.COLUMN_NAME_AVATAR));
                
                EaseUser user = new EaseUser(username);
                user.setNick(nick);
                user.setAvatar(avatar);
                
                users.put(username, user);
			}
			cursor.close();
		}
		return users;	
	}
	
	//ɾ��һ����ϵ��
    synchronized public void deleteContact(String username){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if(db.isOpen()){
            db.delete(UserDao.TABLE_NAME, UserDao.COLUMN_NAME_ID + " = ?", new String[]{username});
        }
    }
	
    //����һ����ϵ��
    synchronized public void saveContact(EaseUser user){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserDao.COLUMN_NAME_ID, user.getUsername());
        if(user.getNick() != null)
            values.put(UserDao.COLUMN_NAME_NICK, user.getNick());
        if(user.getAvatar() != null)
            values.put(UserDao.COLUMN_NAME_AVATAR, user.getAvatar());
        if(db.isOpen()){
            db.replace(UserDao.TABLE_NAME, null, values);
        }
    }
    
    //�ر����ݿ�
    synchronized public void closeDB(){
        if(dbHelper != null){
            dbHelper.closeDB();
        }
        dbMgr = null;
    }

}
