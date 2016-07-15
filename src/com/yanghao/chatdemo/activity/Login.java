package com.yanghao.chatdemo.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.utils.EaseCommonUtils;
import com.yanghao.chatdemo.R;
import com.yanghao.chatdemo.application.DemoHelper;

public class Login extends Activity {
	
	private static final String TAG = Login.class.getSimpleName();
	private EditText username;
	private EditText password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.login);
		super.onCreate(savedInstanceState);
		
		initActionBar();
		initView();
	}
	//初始化ActionBar
	public void initActionBar() {
		ActionBar mToolBar = this.getActionBar();
		//mToolBar.setTitle(R.string.app_name);
		//mToolBar.setDisplayHomeAsUpEnabled(false);//返回
		//mToolBar.setDisplayShowHomeEnabled(false);
		
		mToolBar.hide();
	}
	//初始化View
	public void initView(){
		username = (EditText)findViewById(R.id.username_edit);
		password = (EditText)findViewById(R.id.password_edit);
		//如果用户名改变 密码清空
		username.addTextChangedListener(new TextWatcher(){

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				password.setText(null);
			}

			@Override
			public void afterTextChanged(Editable s) {
				
			}
			
		});
		//如果当前本地有保存用户名则直接显示到用户名编辑框
		String name = DemoHelper.getInstance().getCurrentUserName();
		if (name != null) {
			username.setText(name);
		}
	}
	
	
	//登录验证
	public void login(View view){
		if (!EaseCommonUtils.isNetWorkConnected(this)) {
			Toast.makeText(this, R.string.network_isnot_available, Toast.LENGTH_SHORT).show();
			return;
		}
		String currentUsername = username.getText().toString().trim();
		String currentPassword = password.getText().toString().trim();
		if(TextUtils.isEmpty(currentUsername)){
			Toast.makeText(this, R.string.User_name_cannot_be_empty, Toast.LENGTH_SHORT).show();
			return;
		}
		if(TextUtils.isEmpty(currentPassword)){
			Toast.makeText(this, R.string.Password_cannot_be_empty, Toast.LENGTH_SHORT).show();
			return;
		}
		
		//登录前关闭数据库连接
		//DBManager.getInstance().closeDB();
		//重置先前保存的用户名
		//DemoHelper.getInstance().setCurrentUserName(currentUsername);
		
		EMClient.getInstance().login(currentUsername, currentPassword, new EMCallBack() {
			
			@Override
			public void onSuccess() {
				Log.d(TAG, "login: onSuccess");
			}
			
			@Override
			public void onProgress(int arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onError(int arg0, String arg1) {	
				Log.d(TAG, "login: onError");
			}
		});
		
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		return super.onCreateOptionsMenu(menu);
	}
	
	
	
}
