package com.yanghao.chatdemo.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.yanghao.chatdemo.R;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		initActionBar();
		setContentView(R.layout.login);
		super.onCreate(savedInstanceState);
	}

	private void initActionBar() {
		ActionBar mToolBar = this.getActionBar();
		mToolBar.setTitle(R.string.app_name);
		mToolBar.setDisplayHomeAsUpEnabled(false);//·µ»Ø
		mToolBar.setDisplayShowHomeEnabled(false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		return super.onCreateOptionsMenu(menu);
	}
	
	
	
}
