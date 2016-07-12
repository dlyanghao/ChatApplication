package com.yanghao.chatdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.yanghao.chatdemo.R;

public class SplashActivity extends Activity {
	
	private static final int sleepTime = 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.splash);
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onStart() {
		super.onStart();
		new Thread(new Runnable(){
			@Override
			public void run() {
				long start = System.currentTimeMillis();
				long costTime = System.currentTimeMillis() - start;
				if(sleepTime-costTime>0){
					try {
						Thread.sleep(sleepTime-costTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				startActivity(new Intent(SplashActivity.this,Login.class));
			}
		}).start();
	}
	

}
