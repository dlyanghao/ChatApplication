package com.yanghao.chatdemo.db;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.yanghao.chatdemo.application.DemoHelper;
import com.yanghao.chatdemo.dao.UserDao;

public class DBOpenHelper extends SQLiteOpenHelper{
	
	private static final int DATABASE_VERSION = 6;
	private static DBOpenHelper instance;
	
	
	/**
	 * 创建表SQL语句
	 */
	//用户名表
	private static final String USERNAME_TABLE_CREATE = "CREATE TABLE "
			+ UserDao.TABLE_NAME + " ("
			+ UserDao.COLUMN_NAME_NICK + " TEXT, "
			+ UserDao.COLUMN_NAME_AVATAR + " TEXT, "
			+ UserDao.COLUMN_NAME_ID + " TEXT PRIMARY KEY);";
	
	
	
	//构造函数
	public DBOpenHelper(Context context) {
		super(context, getUserDatabaseName(), null, DATABASE_VERSION);
	}

	//方法：获取数据库名称--加上当前用户名
	private static String getUserDatabaseName() {
		return  DemoHelper.getInstance().getCurrentUserName() + "_demo.db";
	}
	//获取DBOpenHelper实例
	public static DBOpenHelper getInstance(Context context) {
		if (instance == null) {
			instance = new DBOpenHelper(context.getApplicationContext());
		}
		return instance;
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(USERNAME_TABLE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public void closeDB() {
	    if (instance != null) {
	        try {
	            SQLiteDatabase db = instance.getWritableDatabase();
	            db.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        instance = null;
	    }
	}

	

}
